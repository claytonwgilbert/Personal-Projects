package io.javabrains.betterreaderapp.book;

import io.javabrains.betterreaderapp.userbook.UserBook;
import io.javabrains.betterreaderapp.userbook.UserBookRepository;
import io.javabrains.betterreaderapp.userbook.UserBooksPrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    private static final String ROOT_IMAGE_URL = "https://covers.openlibrary.org/b/id/";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserBookRepository userBookRepository;

    @GetMapping("/{bookId}")
    public String getBookById(@PathVariable String bookId, Model model, @AuthenticationPrincipal OAuth2User principal){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            Book foundBook = optionalBook.get();
            String coverImageUrl = "/images/no-image.jpg";
            if(foundBook.getCoverIds() != null){
                coverImageUrl = ROOT_IMAGE_URL + foundBook.getCoverIds().get(0) + "-M.jpg";
            }
            model.addAttribute("coverImage", coverImageUrl);
            model.addAttribute("book", foundBook);

            if(principal != null && principal.getAttribute("login") != null){
                model.addAttribute("loginId", principal.getAttribute("login"));
                UserBooksPrimaryKey key = new UserBooksPrimaryKey();
                key.setUserId(principal.getAttribute("login"));
                key.setBookId(bookId);
                Optional<UserBook> userBookOptional = userBookRepository.findById(key);
                if(userBookOptional.isPresent()){
                    UserBook matchingBook = userBookOptional.get();
                    model.addAttribute("userBook", matchingBook);
                }else{
                    model.addAttribute("userBook", new UserBook());
                }
            }
            return "book";
        }
        return "book-not-found";
    }
}
