package com.cg.shopme.admin.brand;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandRestController {

    private BrandService service;

    public BrandRestController(BrandService service) {
        this.service = service;
    }

    @PostMapping("/brands/check_unique")
    public boolean checkUniqueBrand(@Param("id") Integer id, @Param("name") String name){
        boolean result = service.isBrandUnique(id, name);
        return result;
    }
}
