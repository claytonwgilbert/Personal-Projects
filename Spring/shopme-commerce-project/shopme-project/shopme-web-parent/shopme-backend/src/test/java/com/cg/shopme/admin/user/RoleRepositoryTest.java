package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // - Telling Spring that we don't want to run against default in memory database but instead against our real database we have configured in properties file. Since it's only a test, Spring will automatically rollback any changes made to the database after each test to ensure no permanent changes are made to db tables
@Rollback(false)// - If you want to prevent Spring from rolling back any changes then you can set this property to false which will allow the test to commit changes to the database
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole(){
        Role admin = new Role("Admin", "manages everything");

        Role savedAdmin = roleRepository.save(admin);

        assertThat(savedAdmin.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateOtherRoles(){
        Role salesPerson = new Role("Salesperson", "manages product pricing, customers, " +
                "shipping, orders and sales report.");

        Role editor = new Role("Editor", "manages categories, brands, " +
                "products, articles and menus.");

        Role shipper = new Role("Shipper", "view products, view orders " +
                "and update order status.");

        Role assistant = new Role("Assistant", "manages questions and reviews");

        roleRepository.saveAll(List.of(salesPerson,editor,shipper,assistant));
    }
  
}