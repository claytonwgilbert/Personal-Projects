package com.cg.shopme.admin.category;

import com.cg.shopme.common.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {



    @Query("SELECT c FROM Category c WHERE CONCAT(c.id, ' ', c.name, ' ', c.alias) LIKE %?1%")
    Page<Category> findCategoriesThroughSearch(String keywordSearch, Pageable pageable);

    Category findByName(String name);

    Category findByAlias(String alias);
}
