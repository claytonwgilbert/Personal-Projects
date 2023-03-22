package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(){

        return "contact";
    }

    @PostMapping("/saveMsg")
    public ModelAndView submitContactInfo(Contact contact, Model model){

        boolean saveResults = contactService.saveMessageDetails(contact);
        model.addAttribute("results", saveResults);
        return new ModelAndView("redirect:/contact");
    }
}
