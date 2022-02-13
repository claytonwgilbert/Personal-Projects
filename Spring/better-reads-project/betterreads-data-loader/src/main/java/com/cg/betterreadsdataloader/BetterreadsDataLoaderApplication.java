package com.cg.betterreadsdataloader;

import com.cg.betterreadsdataloader.author.*;
import com.cg.betterreadsdataloader.book.Book;
import com.cg.betterreadsdataloader.book.BookRepository;
import connection.DataStaxAstraProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BetterreadsDataLoaderApplication {

	@Autowired AuthorRepository authorRepository;
	@Autowired BookRepository bookRepository;
	@Autowired AuthorBooksRepository authorBooksRepository;

	@Value("${datadump.location.author}")
	private String authorDataLocation;

	@Value("${datadump.location.works}")
	private String worksDataLocation;

	public static void main(String[] args) {
		SpringApplication.run(BetterreadsDataLoaderApplication.class, args);
	}

	private void initAuthors(){
		Path path = Paths.get(authorDataLocation);
		try{
			Stream<String> lines = Files.lines(path);
			lines.forEach(line -> {
				//read and parse line
				String jsonLine = line.substring(line.indexOf("{"));
				try {
					JSONObject jsonObject = new JSONObject(jsonLine);
					//construct author
					Author author = new Author();
					author.setName(jsonObject.optString("name"));
					author.setPersonalName(jsonObject.optString("personal_name"));
					author.setId(jsonObject.optString("key").replace("/authors/", ""));
					//persist author
					authorRepository.save(author);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private void initWorks(){
		Path path = Paths.get(worksDataLocation);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
		try{
			Stream<String> lines = Files.lines(path);
			lines.forEach(line -> {
				//read and parse line
				String jsonLine = line.substring(line.indexOf("{"));
				try {
					JSONObject jsonObject = new JSONObject(jsonLine);
					//construct book
					Book book = new Book();
					book.setId(jsonObject.getString("key").replace("/works/", ""));
					book.setName(jsonObject.optString("title"));
					JSONObject descriptionObj = jsonObject.optJSONObject("description");
					if(descriptionObj != null){
						book.setDescription(descriptionObj.optString("value"));
					}
					JSONObject publishedObj = jsonObject.optJSONObject("created");
					if(publishedObj != null){
						book.setPublishedDate(LocalDate.parse(publishedObj.getString("value"), dateFormatter));
					}
					JSONArray coversArray = jsonObject.optJSONArray("covers");
					List<String> coverIds = new ArrayList<>();
					if(coversArray != null){
						for(int i = 0; i < coversArray.length(); i++){
							coverIds.add(coversArray.getString(i));
						}
					}
					book.setCoverIds(coverIds);

					JSONArray authorsArray = jsonObject.optJSONArray("authors");
					List<String> authorIds = new ArrayList<>();
					if(authorsArray != null){
						for(int i = 0; i < authorsArray.length(); i++){
							String authorId = authorsArray.getJSONObject(i).getJSONObject("author").getString("key").replace("/authors/","");
							authorIds.add(authorId);
						}
						book.setAuthorIds(authorIds);
						//Set authorbooks author id and matching book info
						List<AuthorBooks> allAuthorWorks = new ArrayList<>();
						authorIds.stream().forEach(authorId -> {
							AuthorBooks authorBook = new AuthorBooks();
							authorBook.setAuthorId(authorId);
							authorBook.setBookTitle(book.getName());
							authorBook.setPublishedDate(book.getPublishedDate());
							allAuthorWorks.add(authorBook);
						});
						allAuthorWorks.stream().forEach(authorBook -> {
							authorBooksRepository.save(authorBook);
						});
						//retrieve author names using ids
						List<String> authorNames = authorIds.stream().map(id -> authorRepository.findById(id))
								.map(authorOptional -> {
									if(!authorOptional.isPresent()) return "Unknown Author";
									return authorOptional.get().getName();
								}).collect(Collectors.toList());
						book.setAuthorNames(authorNames);
					}

					//persist book
					bookRepository.save(book);

				} catch (JSONException e) {
					e.printStackTrace();
				}
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void start(){
		initAuthors();
		initWorks();
	}

	//Giving Spring data the info needed provided by the secure-connect.zip file so it can connect to our cassandra db instance
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}
}
