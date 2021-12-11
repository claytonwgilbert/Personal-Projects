package com.cg.shopme.admin.category;

import com.cg.shopme.common.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // - Telling Spring that we don't want to run against default in memory database but instead against our real database we have configured in properties file. Since it's only a test, Spring will automatically rollback any changes made to the database after each test to ensure no permanent changes are made to db tables
@Rollback(false)// - If you want to prevent Spring from rolling back any changes then you can set this property to false which will allow the test to commit changes to the database
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateRootCategory(){
        Category categoryDesktop = new Category("Computers");
        Category desktopSaved = categoryRepository.save(categoryDesktop);
        Category categoryElectronics = new Category("Electronics");
        Category electronicsSaved = categoryRepository.save(categoryElectronics);

        assertThat(desktopSaved.getId()).isGreaterThan(0);
        assertThat(electronicsSaved.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateSubCategory(){
        Category parent = new Category(7);
        Category iphone = new Category("iPhone", parent);

        categoryRepository.save(iphone);
    }



}