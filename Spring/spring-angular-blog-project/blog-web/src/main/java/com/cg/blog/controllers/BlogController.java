package com.cg.blog.controllers;

import com.cg.blog.domain.BlogPost;
import com.cg.blog.services.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/posts")
    public HashMap<String, Object> getBlogPosts(@RequestParam("page") Long page) throws Exception {
        Pageable pageable = PageRequest.of(page != null ? (page.intValue() - 1) : 0, 1, Sort.by("id").descending());

        Page<BlogPost> portion = blogService.findAll(pageable);

        List<BlogPost> blogPosts = portion.getContent();

        if (pageable.getPageNumber() < 0 || pageable.getPageNumber() > portion.getTotalPages()) {
            throw new Exception("Out of bounds results when retrieving blog posts");
        }

        HashMap<String, Object> results = new HashMap<>();
        results.put("blogPosts", blogPosts);
        results.put("pagination", blogService.createPaginationModel(portion));

        return results;
    }

    @GetMapping("/blog/posts/{id}")
    public Optional<BlogPost> getBlogPost(@PathVariable("id") Long id) {
        return blogService.findById(id);
    }
}
