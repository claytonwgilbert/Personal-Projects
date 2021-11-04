package com.cg.blog.services;

import com.cg.blog.domain.BlogPost;
import com.cg.blog.repositories.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Page<BlogPost> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }


    public Optional<BlogPost> findById(Long id){
        return blogRepository.findById(id);
    }


    public HashMap<String, Object> createPaginationModel(Page<BlogPost> portion) {
        HashMap<String, Object> results = new HashMap<>();

        results.put("currentPage", portion.getNumber());
        results.put("totalPages", portion.getTotalPages());
        results.put("pages", getPages(portion.getNumber(), portion.getTotalPages() - 1));

        return results;
    }

    private ArrayList<Integer> getPages(int currentPage, int numberOfPages){
        ArrayList<Integer> pages = new ArrayList<>();

        if(currentPage > 0){
            pages.add(currentPage - 1);
        }
        pages.add(currentPage);

        if(currentPage < numberOfPages){
            pages.add(currentPage + 1);
        }

        return pages;
    }
}
