package io.javabrains.betterreaderapp.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    private final WebClient webClient;
    private static final String ROOT_IMAGE_URL = "https://covers.openlibrary.org/b/id/";


    public SearchController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                        .build())
                .baseUrl("http://openlibrary.org/search.json")
                .build();
    }

    @GetMapping("/search")
    public String searchBookByTitle(@RequestParam String query, Model model){
        Mono<SearchResult> resultsMono = this.webClient.get()
                      .uri("?q={query}", query)
                      .retrieve()
                      .bodyToMono(SearchResult.class);
        SearchResult result = resultsMono.block();
        List<SearchResultBook> books = result.getDocs()
                                             .stream()
                                             .limit(10)
                                             .map(bookResult -> {
                                                 bookResult.setKey(bookResult.getKey().replace("/works/",""));
                                                 String coverId = bookResult.getCover_i();
                                                 if(StringUtils.hasText(coverId)){
                                                     coverId = ROOT_IMAGE_URL + coverId + "-M.jpg";
                                                 }else{
                                                     coverId = "/images/no-image.jpg";
                                                 }
                                                 bookResult.setCover_i(coverId);
                                                 return bookResult;
                                             })
                                             .collect(Collectors.toList());
        model.addAttribute("books", books);

        return "search";
    }
}
