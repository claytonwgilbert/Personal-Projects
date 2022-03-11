package com.cg.classrosterfullstackapp.students;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void checksIfStudentExistsByEmail() {
        //given
        Student student = new Student("Jane Doe","janedoe@gmail.com", Gender.FEMALE);
        studentRepository.save(student);
        //when
        Student fromRepo = studentRepository.findStudentByEmail(student.getEmail());
        //then
        assertEquals(student, fromRepo);
    }
}