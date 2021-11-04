package com.cg.blog.repositories;

import com.cg.blog.domain.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<BlogPost, Long> {
    Page<BlogPost> findAll(Pageable pageable);
}
