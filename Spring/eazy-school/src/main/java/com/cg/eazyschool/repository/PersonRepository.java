package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
