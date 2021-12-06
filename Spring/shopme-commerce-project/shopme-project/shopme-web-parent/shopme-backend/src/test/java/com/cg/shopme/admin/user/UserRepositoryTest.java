package com.cg.shopme.admin.user;

import com.cg.shopme.common.entity.Role;
import com.cg.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // - Telling Spring that we don't want to run against default in memory database but instead against our real database we have configured in properties file. Since it's only a test, Spring will automatically rollback any changes made to the database after each test to ensure no permanent changes are made to db tables
@Rollback(false)// - If you want to prevent Spring from rolling back any changes then you can set this property to false which will allow the test to commit changes to the database
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserOneRole(){
        Role roleAdmin = entityManager.find(Role.class, 1);

        User userGilbert = new User("Clayton","Gilbert","claytonwgilbert@gmail.com","password");
        userGilbert.addRole(roleAdmin);

        User savedUser = userRepository.save(userGilbert);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }


    @Test
    public void testCreateUserTwoRoles() {
        User userDestinee = new User("Destinee","Gilbert","rhoadesdestinee@yahoo.com","password");
        Role assistant = new Role(5);
        Role editor = new Role(3);
        userDestinee.addRole(assistant);
        userDestinee.addRole(editor);

        User savedUser = userRepository.save(userDestinee);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testGetAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        allUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        Optional<User> user = userRepository.findById(1);
        assertThat(user.get()).isNotNull();
    }

    @Test
    public void testUpdateUser(){
        User user = userRepository.findById(1).get();
        user.setEnabled(true);

        userRepository.save(user);
    }

    @Test
    public void testUpdateUserRoles(){
        User userDestinee = userRepository.findById(2).get();

        Role assistant = new Role(5);
        Role editor = new Role(3);
        userDestinee.getRoles().remove(assistant);
        userDestinee.getRoles().remove(editor);
        Role salesPerson = new Role(2);
        Role shipper = new Role(4);

        userDestinee.getRoles().add(salesPerson);
        userDestinee.getRoles().add(shipper);

        userRepository.save(userDestinee);
    }

    @Test
    public void testDeletedUser(){
        // - ID 2 previously deleted...
        Optional<User> user = userRepository.findById(2);
        assertThat(user).isEmpty();
    }

    @Test
    public void testEnableDisableUser(){
        User user = userRepository.findById(3).get();
        assertThat(user.isEnabled() == true);
        userRepository.updateEnabledStatus(3, false);
        User userUpdated = userRepository.findById(3).get();
        assertThat(userUpdated.isEnabled() == false);
    }

    @Test
    public void testSearchForUser(){
        String searchTerm = "Bruce";

        int pageNumberMin = 0;
        int pageNumberMax = 4;
        Pageable page = PageRequest.of(pageNumberMin, pageNumberMax);

        Page<User> foundUsers = userRepository.findUsersThroughSearch(searchTerm, page);

        List<User> usersList = foundUsers.getContent();

        usersList.forEach(user -> System.out.println(user));

        assertThat(usersList.size()).isGreaterThan(0);
    }




    }
