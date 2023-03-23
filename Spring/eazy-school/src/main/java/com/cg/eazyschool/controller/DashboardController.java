package com.cg.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String displayDashboardPage(Authentication authentication, Model model){
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());

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
