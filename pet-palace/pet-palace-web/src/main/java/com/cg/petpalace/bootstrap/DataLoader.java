package com.cg.petpalace.bootstrap;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.model.Pet;
import com.cg.petpalace.model.PetType;
import com.cg.petpalace.model.Vet;
import com.cg.petpalace.services.OwnerService;
import com.cg.petpalace.services.PetTypeService;
import com.cg.petpalace.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService){
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    //Spring will run this as soon as the application starts first thing. Great place to load up initial data for the
    //application.
    @Override
    public void run(String... args) throws Exception {


        PetType dogType = new PetType();
        dogType.setPetType("Dog");
        PetType savedDogPetType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setPetType("Cat");
        PetType savedCatPetType = petTypeService.save(catType);

        Owner eddy = new Owner();
        eddy.setFirstName("Eddy");
        eddy.setLastName("Coolio");
        eddy.setAddress("3323 Leep Lane");
        eddy.setCity("Springfield");
        eddy.setPhone("5556547789");

        Pet eddysPet = new Pet();
        eddysPet.setName("Constanzo");
        eddysPet.setPetType(savedDogPetType);
        eddysPet.setBirthDate(LocalDate.now());
        eddysPet.setOwner(eddy);
        eddy.getPets().add(eddysPet);

        ownerService.save(eddy);

        Owner laura = new Owner();
        laura.setFirstName("Laura");
        laura.setLastName("Faye");
        laura.setAddress("3323 Leep Lane");
        laura.setCity("Springfield");
        laura.setPhone("5557003177");

        Pet laurasPet = new Pet();
        laurasPet.setName("Sheela");
        laurasPet.setPetType(savedCatPetType);
        laurasPet.setBirthDate(LocalDate.now());
        laurasPet.setOwner(laura);
        laura.getPets().add(laurasPet);

        ownerService.save(laura);

        System.out.println("Owners Loaded DONE ------------------");

        Vet vet = new Vet();
        vet.setFirstName("Melinda");
        vet.setLastName("Crosby");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Teisha");
        vet2.setLastName("Lynn");

        vetService.save(vet2);

        System.out.println("Vets Loaded DONE ------------------");


    }
}
