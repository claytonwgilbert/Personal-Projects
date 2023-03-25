package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {
    private PersonService personService;

    public PublicController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/register")
    public String displayUserRegistrationForm(Model model){
        model.addAttribute("person", new Person());

        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors){
        if(errors.hasErrors()){
            return "register";
        }
        return "redirect:/login?register=true";
    }

}
