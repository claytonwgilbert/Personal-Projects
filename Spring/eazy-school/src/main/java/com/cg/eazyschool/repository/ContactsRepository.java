package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByStatus(String status);
}
