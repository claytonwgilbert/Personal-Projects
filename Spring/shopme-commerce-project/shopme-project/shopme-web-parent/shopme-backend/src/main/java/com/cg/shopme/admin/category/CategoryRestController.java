package com.cg.shopme.admin.category;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryRestController {

    private CategoryService service;

    public CategoryRestController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/categories/check_unique")
    public boolean checkUniqueCategory(@Param("id") Integer id, @Param("name") String name, @Param("alias") String alias){
        boolean result = service.isCategoryUnique(id, name, alias);
        return result;
    }
}
