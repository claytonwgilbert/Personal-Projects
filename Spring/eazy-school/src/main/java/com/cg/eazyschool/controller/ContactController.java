package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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
    public String submitContactInfo(@Valid @ModelAttribute("contact") Contact contact, Model model, Errors errors){
        if(errors.hasErrors()){
            log.error("There were errors submitting your form: ", errors.toString());
            return "contact";
        }
        boolean saveResults = contactService.saveMessageDetails(contact);
        model.addAttribute("results", saveResults);
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages")
    public ModelAndView displayMessages(){
        List<Contact> messages = contactService.findMsgsWithOpenStatus();
        ModelAndView viewMessages = new ModelAndView("messages");
        viewMessages.addObject("contactMsgs", messages);

        return viewMessages;
    }


    @GetMapping("/closeMapping")
    public String closeMsg(@RequestParam int id, Authentication authentication){
        contactService.updateMsgStatus(id, authentication.getName());
        return "redirect:/displayMessages";
    }
}
