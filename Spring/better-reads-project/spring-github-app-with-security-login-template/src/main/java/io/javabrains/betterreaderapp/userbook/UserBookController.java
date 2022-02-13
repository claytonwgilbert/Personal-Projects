package io.javabrains.betterreaderapp.userbook;

import io.javabrains.betterreaderapp.book.Book;
import io.javabrains.betterreaderapp.book.BookRepository;
import io.javabrains.betterreaderapp.user.BooksByUser;
import io.javabrains.betterreaderapp.user.BooksByUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class UserBookController {

    @Autowired
    private UserBookRepository userBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksByUserRepository booksByUserRepository;

    @PostMapping("/addUserBook")
    public ModelAndView saveUserBook(@AuthenticationPrincipal OAuth2User user, @RequestBody MultiValueMap<String, String> formData){
        if(user == null || user.getAttribute("login") == null){
            return null;
        }

        String bookId = formData.getFirst("bookId");
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(!bookOptional.isPresent()){
            return new ModelAndView("redirect:/");
        }
        Book matchingBook = bookOptional.get();

        UserBooksPrimaryKey primaryKey = new UserBooksPrimaryKey();
        UserBook userBook = new UserBook();
        userBook.setKey(primaryKey);
        primaryKey.setBookId(bookId);
        primaryKey.setUserId(user.getAttribute("login"));
        userBook.setStartedDate(LocalDate.parse(formData.getFirst("dateStarted")));
        userBook.setCompletedDate(LocalDate.parse(formData.getFirst("dateFinished")));
        userBook.setReadingStatus(formData.getFirst("status"));
        userBook.setRating(Integer.parseInt(formData.getFirst("rating")));

        userBookRepository.save(userBook);

        BooksByUser booksByUser = new BooksByUser();
        booksByUser.setId(user.getAttribute("login"));
        booksByUser.setBookId(bookId);
        booksByUser.setBookName(matchingBook.getName());
        booksByUser.setCoverIds(matchingBook.getCoverIds());
        booksByUser.setAuthorNames(matchingBook.getAuthorNames());
        booksByUser.setRating(Integer.parseInt(formData.getFirst("rating")));
        booksByUser.setReadingStatus(formData.getFirst("status"));

        booksByUserRepository.save(booksByUser);

        return new ModelAndView("redirect:/books/" + bookId);
    }
}
