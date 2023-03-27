package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Courses;
import com.cg.eazyschool.model.EazyClass;
import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.repository.CoursesRepository;
import com.cg.eazyschool.repository.EazyClassRepository;
import com.cg.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    private EazyClassRepository eazyClassRepository;
    private PersonRepository personRepository;
    private CoursesRepository coursesRepository;

    public AdminController(EazyClassRepository eazyClassRepository, PersonRepository personRepository, CoursesRepository coursesRepository) {
        this.eazyClassRepository = eazyClassRepository;
        this.personRepository = personRepository;
        this.coursesRepository = coursesRepository;
    }

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(){
        List<EazyClass> allClasses = eazyClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes");
        modelAndView.addObject("eazyClass", new EazyClass());
        modelAndView.addObject("eazyClasses", allClasses);
        return modelAndView;
    }

    @RequestMapping("/addNewClass")
    public String addNewClass(@ModelAttribute("eazyClass") EazyClass eazyClass){
        eazyClassRepository.save(eazyClass);

        return "redirect:/admin/displayClasses";
    }

    @RequestMapping("/displayStudents")
    public ModelAndView displayStudents(@RequestParam("classId") int classId,
                                        @RequestParam(value = "error", required = false) String error,
                                        HttpSession httpSession){
        String errorMessage = null;
        Optional<EazyClass> eazyClass = eazyClassRepository.findById(classId);
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("eazyClass", eazyClass.get());
        modelAndView.addObject("person", new Person());
        httpSession.setAttribute("eazyClass", eazyClass.get()); //Storing class in the session so we can know which class we are referencing when attempting to add a new student to it, otherwise that class information will be lost
        if(error != null){
            errorMessage = "Invalid email";
            modelAndView.addObject("errorMessage", errorMessage);
        }

        return modelAndView;
    }

    @RequestMapping("/deleteClass")
    public String deleteClass(@RequestParam("classId") int classId){
        Optional<EazyClass> classToDelete = eazyClassRepository.findById(classId);
        for(Person p : classToDelete.get().getStudents()){
            p.setEazyClass(null);
            personRepository.save(p);
        }
        eazyClassRepository.deleteById(classId);
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping("/addStudent")
    public String addStudent(@ModelAttribute("person") Person person, HttpSession httpSession){
        EazyClass classAsscociated = (EazyClass) httpSession.getAttribute("eazyClass");
        Person matchingStudent = personRepository.readByEmail(person.getEmail());
        if(matchingStudent == null){
            return "redirect:/admin/displayStudents?classId=" + classAsscociated.getClassId() + "&error=true";
        }
        person.setEazyClass(classAsscociated);
        personRepository.save(matchingStudent);

        classAsscociated.getStudents().add(matchingStudent);
        eazyClassRepository.save(classAsscociated);

        return "redirect:/admin/displayClasses?classId=" + classAsscociated.getClassId();
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("personId") int personId, HttpSession httpSession){
        EazyClass classAsscociated = (EazyClass) httpSession.getAttribute("eazyClass");
        Person personToDelete = personRepository.findById(personId).get();
        personToDelete.setEazyClass(null);
        classAsscociated.getStudents().remove(personToDelete);
        EazyClass savedEazyClass = eazyClassRepository.save(classAsscociated);
        httpSession.setAttribute("eazyClass", savedEazyClass);

        return "redirect:/admin/displayClasses?classId=" + classAsscociated.getClassId();
    }

    @RequestMapping("/displayCourses")
    public ModelAndView displayCourses(){
        List<Courses> allCourses = coursesRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("courses_secure");
        modelAndView.addObject("courses", allCourses);
        modelAndView.addObject("course", new Courses());

        return modelAndView;
    }

    @RequestMapping("/addNewCourse")
    public String addNewCourse(@ModelAttribute("course") Courses course){
        coursesRepository.save(course);

        return "redirect:/admin/displayCourses";
    }

    @RequestMapping("/viewStudents")
    public String viewCourseStudents(@PathVariable("courseId") int courseId,
                                     @PathVariable(value = "error", required = false) String error,
                                     Model model, HttpSession httpSession){
        String errorMessage = null;
        Optional<Courses> matchingCourse = coursesRepository.findById(courseId);
        model.addAttribute("courses", matchingCourse.get());
        model.addAttribute("person", new Person());
        httpSession.setAttribute("courses", matchingCourse.get());

        if(error != null){
            errorMessage = "Invalid email entered!";
            model.addAttribute("errorMessage", errorMessage);
        }

        return "course_students";
    }

    @PostMapping("/addStudentToCourse")
    public String viewCourseStudents(@ModelAttribute("person") Person person, Model model, HttpSession httpSession){
        Courses courseToAddTo = (Courses) httpSession.getAttribute("courses");
        Person personToAdd = personRepository.readByEmail(person.getEmail());
        if(personToAdd == null){
            return "redirect:/admin/viewStudents?courseId=" + courseToAddTo.getCourseId() + "&error=true";
        }
        courseToAddTo.getPersons().add(personToAdd);
        personToAdd.getCourses().add(courseToAddTo);
        personRepository.save(personToAdd);
        httpSession.setAttribute("courses", courseToAddTo);

        return "redirect:/admin/viewStudents?courseId=" + courseToAddTo.getCourseId();
    }

    @DeleteMapping("/deleteStudentFromCourse")
    public String deleteStudentFromCourse(@RequestParam("personId") int personId, HttpSession httpSession){
        Courses courseAsscociated = (Courses) httpSession.getAttribute("courses");
        Person personToDelete = personRepository.findById(personId).get();
        personToDelete.getCourses().remove(courseAsscociated);
        courseAsscociated.getPersons().remove(personToDelete);
        personRepository.save(personToDelete);
        httpSession.setAttribute("courses", courseAsscociated);

        return "redirect:/admin/viewStudents?courseId=" + courseAsscociated.getCourseId();
    }
}

