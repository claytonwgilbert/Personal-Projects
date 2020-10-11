package com.cg.petpalace.bootstrap;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.model.Vet;
import com.cg.petpalace.services.OwnerService;
import com.cg.petpalace.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService){
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    //Spring will run this as soon as the application starts first thing. Great place to load up initial data for the
    //application.
    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Eddy");
        owner.setLastName("Coolio");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Laura");
        owner2.setLastName("Faye");

        ownerService.save(owner2);

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
