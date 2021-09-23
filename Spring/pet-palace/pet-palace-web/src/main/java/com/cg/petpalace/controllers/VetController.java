package com.cg.petpalace.controllers;

import com.cg.petpalace.model.Vet;
import com.cg.petpalace.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html","/vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> listVetsJson(){
        return vetService.findAll();
    }
}