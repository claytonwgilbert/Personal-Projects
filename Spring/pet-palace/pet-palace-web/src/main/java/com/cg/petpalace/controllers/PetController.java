package com.cg.petpalace.controllers;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.model.Pet;
import com.cg.petpalace.model.PetType;
import com.cg.petpalace.services.OwnerService;
import com.cg.petpalace.services.PetService;
import com.cg.petpalace.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @GetMapping("/pets/new")
    public String displayCreatePetForm(@Valid Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);

        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreatePetForm(Owner owner, Pet pet, BindingResult results, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            results.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (results.hasErrors()) {
            return "pets/createOrUpdatePetForm";
        }
        petService.save(pet);

        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/pets/{petId}/edit")
    public String displayUpdatePetForm(@PathVariable("petId") Long id, Model model) {
        model.addAttribute("pet", petService.findById(id));

        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdatePetForm(@PathVariable("petId") Long petId, Pet pet, Owner owner, BindingResult results, Model model) {
        if (results.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }
        owner.getPets().add(pet);
        petService.save(pet);
        return "redirect:owners/" + owner.getId();

    }

}
