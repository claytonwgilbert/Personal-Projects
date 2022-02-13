package io.javabrains.betterreaderapp.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorBooksRepository authorBooksRepository;

    @GetMapping("/author/{id}")
    public String showAuthorsPage(Model model, @PathVariable String id){
        Slice<AuthorBooks> authorBooksSlice = authorBooksRepository.findAllById(id, CassandraPageRequest.of(0, 15));
        List<AuthorBooks> authorBooks = authorBooksSlice.getContent();

        model.addAttribute("author", authorRepository.findById(id).get());
        model.addAttribute("books", authorBooks);

        return "author";
    }
}
