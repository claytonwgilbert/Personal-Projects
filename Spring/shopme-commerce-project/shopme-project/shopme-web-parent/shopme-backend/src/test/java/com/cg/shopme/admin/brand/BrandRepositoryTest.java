package com.cg.shopme.admin.brand;

import com.cg.shopme.common.entity.Brand;
import com.cg.shopme.common.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // - Telling Spring that we don't want to run against default in memory database but instead against our real database we have configured in properties file. Since it's only a test, Spring will automatically rollback any changes made to the database after each test to ensure no permanent changes are made to db tables
@Rollback(true)// - If you want to prevent Spring from rolling back any changes then you can set this property to false which will allow the test to commit changes to the database
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    public void testFindBrandList(){
        Brand brandAcer = new Brand();
        brandAcer.setName("Acer");
        brandAcer.setLogo("AcerImage.png");

        brandRepository.save(brandAcer);
        List<Brand> brandSaved = brandRepository.findByName("Acer");

        assertThat(brandSaved.size()).isEqualTo(1);
    }

}