package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Contact;
import com.cg.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/displayMessages/page/{pageNum}")
    public ModelAndView displayMessages(@PathVariable(name = "pageNum") int pageNum,
                                        @RequestParam("sortField") String sortField,
                                        @RequestParam("sortDir") String sortDir,
                                        Model model){
        Page<Contact> messages = contactService.findMsgsWithOpenStatus(pageNum, sortField, sortDir);
        List<Contact> contactMessages = messages.getContent();
        ModelAndView viewMessages = new ModelAndView("messages");
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", messages.getTotalPages());
        model.addAttribute("totalMsgs", messages.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        viewMessages.addObject("contactMsgs", contactMessages);

        return viewMessages;
    }


    @GetMapping("/closeMapping")
    public String closeMsg(@RequestParam int id){
        contactService.updateMsgStatus(id);

        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }
}
