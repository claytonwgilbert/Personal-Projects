package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/saveMsg")
    public String submitContactInfo(@Validated @ModelAttribute("contact") Contact contact, Model model, Errors errors){
        if(errors.hasErrors()){
            log.error("There were errors submitting your form: ", errors.toString());
            return "contact";
        }
        boolean saveResults = contactService.saveMessageDetails(contact);
        model.addAttribute("results", saveResults);
        return "redirect:/contact";
    }
}
