package com.cg.spring.data.jpa.example.repository;

import com.cg.spring.data.jpa.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    // - Returns names matching the small part being searched by...like returning Johnson when only searching for John
    List<Student> findByFirstNameContaining(String partOfAName);

    List<Student> findByLastNameNotNull(String lastName);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstnameAndLastname(String firstName, String lastName);

    //JPQL - based on classes not tables
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String email);

    // - Native Query, runs pure sql against database itself, most powerful
    @Query(
            value = "select * from tbl_students where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    // - Named Param, like native but more readable
    @Query(
            value = "select * from tbl_students where s.email_address = :email",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNamedParam(@Param("email") String email);

    @Transactional
    @Modifying
    @Query(
            value = "update tbl_students set s.first_name = ?1 where student.email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String name, String email);


}
