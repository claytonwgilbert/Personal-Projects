package com.cg.shopme.admin.category;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
