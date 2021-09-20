package com.cg.petpalace.controllers;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void notAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public String findOwnerFormPage(Model model){
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindOwnersForm(@Valid Owner owner, Model model, BindingResult result){

        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> ownerResults = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(ownerResults.isEmpty()){
            result.rejectValue("lastName", "NotFound", "not found");
        }else if(ownerResults.size() == 1){
            owner = ownerResults.get(0);
            return "redirect:/owners/" + owner.getId();
        }else{
            model.addAttribute("selections", ownerResults);
            return "owners/ownersList";
        }

        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public String displayOwner(@PathVariable("ownerId") Long id, Model model){
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/ownerDetails";
    }

    @GetMapping("/new")
    public String displayCreateOwnerForm(Model model){
        model.addAttribute("owner", Owner.builder().id(1l).build());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreateOwnerForm(@Valid Owner owner, BindingResult results){
        if(results.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }
        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String displayUpdateOwnerForm(@PathVariable("ownerId") Long id, Model model){
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@PathVariable("ownerId") Long id, @Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            owner.setId(id);
            Owner updatedOwner = ownerService.save(owner);
            return "redirect:/owners/" + updatedOwner.getId();
        }
    }
}
