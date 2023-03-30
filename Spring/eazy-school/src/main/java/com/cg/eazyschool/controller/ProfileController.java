package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Address;
import com.cg.eazyschool.model.Person;
import com.cg.eazyschool.model.Profile;
import com.cg.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller("ProfileControllerBean")
public class ProfileController {

    private PersonRepository personRepository;

    public ProfileController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/displayProfile")
    public ModelAndView displayProfile(HttpSession httpSession){
        Person loggedInPerson = (Person) httpSession.getAttribute("loggedInPerson");
        Profile profile = new Profile();
        profile.setName(loggedInPerson.getName());
        profile.setEmail(loggedInPerson.getEmail());
        profile.setMobileNumber(loggedInPerson.getMobileNumber());
        if(loggedInPerson.getAddress() != null){
            profile.setAddress1(loggedInPerson.getAddress().getAddress1());
            profile.setAddress2(loggedInPerson.getAddress().getAddress2());
            profile.setCity(loggedInPerson.getAddress().getCity());
            profile.setState(loggedInPerson.getAddress().getState());
            profile.setZipCode(loggedInPerson.getAddress().getZipCode());
        }
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("profile", new Profile());

        return modelAndView;
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors, HttpSession httpSession){
        if(errors.hasErrors()){
            return "profile";
        }
        Person personToUpdate = (Person) httpSession.getAttribute("loggedInPerson");
        personToUpdate.setName(profile.getName());
        personToUpdate.setEmail(profile.getEmail());
        personToUpdate.setMobileNumber(profile.getMobileNumber());
        if(personToUpdate.getAddress() == null){
            personToUpdate.setAddress(new Address());
        }
        personToUpdate.getAddress().setAddress1(profile.getAddress1());
        personToUpdate.getAddress().setAddress2(profile.getAddress2());
        personToUpdate.getAddress().setCity(profile.getCity());
        personToUpdate.getAddress().setState(profile.getState());
        personToUpdate.getAddress().setZipCode(profile.getZipCode());

        personRepository.save(personToUpdate);
        httpSession.setAttribute("loggedInPerson", personToUpdate);

        return "redirect:/displayProfile";
    }

}
