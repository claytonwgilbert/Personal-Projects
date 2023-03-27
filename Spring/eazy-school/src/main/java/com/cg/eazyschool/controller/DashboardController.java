package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class DashboardController {

    private PersonRepository personRepository;

    public DashboardController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/dashboard")
    public String displayDashboardPage(Authentication authentication, Model model, HttpSession httpSession){
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(person.getEazyClass() != null){
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        httpSession.setAttribute("loggedInPerson", person); //Adding our loggedIn user to a session so we can retrieve whenever we need for the profile page in order to give the ability to update the person logged in functionality

        return "dashboard";
    }

/*
    Example of exception handler at class level(only handles exceptions thrown by this class
    @ExceptionHandler({NullPointerException.class, ArrayIndexOutOfBoundsException.class, IOException.class})
    public ModelAndView globalExceptionHandler(RuntimeException exception){
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errorMessage", exception);

        return errorPage;
    }*/
}
