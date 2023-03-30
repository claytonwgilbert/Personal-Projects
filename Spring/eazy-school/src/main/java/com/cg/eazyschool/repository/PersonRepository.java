package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
}
