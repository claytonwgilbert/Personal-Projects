package com.cg.blog.controllers;

import com.cg.blog.domain.BlogPost;
import com.cg.blog.repositories.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogAdminController {

    private BlogRepository blogRepository;

    public BlogAdminController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/")
    public String addBlogPost(Model model){
        model.addAttribute("blogPost", new BlogPost());

        return "add-blog-post";
    }

    @PostMapping("/createblogpost")
    public String addBlogPost(@ModelAttribute("blogPost") BlogPost blogPost){
        blogRepository.save(blogPost);

        return "save-confirmation-page";
    }

}
