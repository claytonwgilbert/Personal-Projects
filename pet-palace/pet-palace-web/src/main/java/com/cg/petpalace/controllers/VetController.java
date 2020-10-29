package com.cg.petpalace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    @RequestMapping({"","/","/index","/index.html","/vets.html"})
    public String listVets(){

        return "vets/index";
    }
}
