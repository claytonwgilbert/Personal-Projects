package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends PagingAndSortingRepository<Contact, Integer> {
    List<Contact> findByStatus(String status);
}
