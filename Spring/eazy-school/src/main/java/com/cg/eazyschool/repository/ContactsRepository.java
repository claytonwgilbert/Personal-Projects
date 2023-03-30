package com.cg.eazyschool.repository;

import com.cg.eazyschool.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

    @Query("SELECT c FROM Contact c WHERE c.status = :status") //JPQL...works for every database implementation unlike Native queries where some keywords don't transfer to other database if migrating. JPQL works with the class itself instead of against the database
    //@Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status", nativeQuery = true)
    Page<Contact> findByStatusQuery(@Param("status") String status, Pageable pageable); //If you want to use :parameter style and you want the method parameter to match the name in the query, you need the @Param annotation to prevent ambiguity

    @Transactional
    @Modifying
    @Query("UPDATE Contact c SET c.status = ?1 WHERE c.contactId = ?2") //?1 and ?2 signifies the number of the parameter in the method, alternative to :parameter style
    int updateStatusById(String status, int id);
}
