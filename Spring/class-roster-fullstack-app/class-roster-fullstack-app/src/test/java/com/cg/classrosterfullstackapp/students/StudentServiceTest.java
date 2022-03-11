package com.cg.classrosterfullstackapp.students;

import com.cg.classrosterfullstackapp.students.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;
    @InjectMocks
    private StudentService service;
    Student testStudent;

    @BeforeEach
    void setUp() {
        testStudent = new Student(1l,"Jameson Doel", "janedoe@gmail.com", Gender.MALE);
    }

    @Test
    void getAllStudents() {
        //when
        service.getAllStudents();
        //then
        verify(repository).findAll();
    }

    @Test
    void getStudentById() {
        when(service.getStudentById(anyLong())).thenReturn(testStudent);

        Student returnedStudent = service.getStudentById(1l);

        assertNotNull(returnedStudent);
    }

    @Test
    void createNewStudent() {
        Student student = new Student("Jane Doe","janedoe@gmail.com", Gender.FEMALE);

        service.createNewStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(repository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void throwExceptionCreatingStudentWithDuplicateEmail() {
        doThrow(BadRequestException.class).when(service).createNewStudent(any());

        assertThatThrownBy(() -> service.createNewStudent(testStudent))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessageContaining("Error... Email of " + testStudent.getEmail() + " already exists.");

        verify(repository, never()).save(any());
    }

    @Test
    void deleteStudent() {
        service.deleteStudent(testStudent.getId());

        verify(repository).deleteById(anyLong());
    }

    @Test
    void updateStudent() {
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(service).updateStudent(studentArgumentCaptor.capture(), any());
    }
}