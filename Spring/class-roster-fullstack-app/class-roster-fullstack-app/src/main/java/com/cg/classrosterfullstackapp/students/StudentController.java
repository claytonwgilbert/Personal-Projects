package com.cg.classrosterfullstackapp.students;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(Model model){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Long id) throws Exception{
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createNewStudent(@Valid @RequestBody Student student, BindingResult results) throws Exception {
        studentService.createNewStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
    }

    @PutMapping("/edit")
    public void updateStudent(@Valid @RequestBody Student newStudent){
        studentService.updateStudent(newStudent, newStudent.getId());
    }

}
