package com.cg.shopme.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.cg.shopme.common.entity"}) //- Since this entity class does not exist under any subpackages of this project, and instead lives in the common project, we have to tell Spring where to find said entity class in order to create database table
public class ShopmeBackendProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopmeBackendProjectApplication.class, args);
    }

}
