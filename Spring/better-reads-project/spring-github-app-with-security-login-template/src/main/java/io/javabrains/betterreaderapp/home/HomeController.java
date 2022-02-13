package io.javabrains.betterreaderapp.home;

import io.javabrains.betterreaderapp.user.BooksByUser;
import io.javabrains.betterreaderapp.user.BooksByUserRepository;
import io.javabrains.betterreaderapp.userbook.UserBook;
import io.javabrains.betterreaderapp.userbook.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private static final String ROOT_IMAGE_URL = "https://covers.openlibrary.org/b/id/";

    @Autowired
    private BooksByUserRepository booksByUserRepository;

    @GetMapping("/")
    public String userPage(@AuthenticationPrincipal OAuth2User principal, Model model){
        if(principal == null && principal.getAttribute("login") == null) {
            return "index";
        }
        Slice<BooksByUser> userBooksSlice = booksByUserRepository.findAllById(principal.getAttribute("login"), CassandraPageRequest.of(0, 100));
        List<BooksByUser> userBooks = userBooksSlice.getContent();
        userBooks = userBooks.stream().distinct().map(book -> {
            String coverImageUrl = "/images/no-image.jpg";
            if(book.getCoverIds() != null){
                coverImageUrl = ROOT_IMAGE_URL + book.getCoverIds().get(0) + "-M.jpg";
            }
            book.setCoverUrl(coverImageUrl);
            return book;
        }).collect(Collectors.toList());

        model.addAttribute("books", userBooks);
        return "home";

    }
}
