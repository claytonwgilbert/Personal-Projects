package com.cg.classrosterfullstackapp.students;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(Model model){
        List<Student> students = Arrays.asList(
                new Student(1L, "Jonathon Coolidge", "jcool@gmail.com", Gender.MALE),
                new Student(2L, "Foraker Whendle", "forkboy@yahoo.com", Gender.OTHER),
                new Student(3L, "Fiona James", "ilikeshrek@gmail.com", Gender.FEMALE),
                new Student(4L, "Cotton Pensacola", "pensacolaccc@hotmail.com", Gender.MALE)
                );
        return students;
    }

}
