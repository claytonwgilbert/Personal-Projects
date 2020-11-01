package com.cg.petpalace.bootstrap;

import com.cg.petpalace.model.*;
import com.cg.petpalace.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    //Spring will run this as soon as the application starts first thing. Great place to load up initial data for the
    //application.
    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }


    private void loadData(){
            PetType dogType = new PetType();
            dogType.setName("Dog");
            PetType savedDogPetType = petTypeService.save(dogType);

            PetType catType = new PetType();
            catType.setName("Cat");
            PetType savedCatPetType = petTypeService.save(catType);

            Specialty radiology = new Specialty();
            radiology.setDescription("radiology");
            Specialty savedRadiologySpecialty = specialtyService.save(radiology);

            Specialty surgery = new Specialty();
            surgery.setDescription("surgery");
            Specialty savedSurgerySpecialty = specialtyService.save(surgery);

            Specialty dentistry = new Specialty();
            dentistry.setDescription("dentistry");
            Specialty savedDentistrySpecialty = specialtyService.save(dentistry);

            Owner eddy = new Owner();
            eddy.setFirstName("Eddy");
            eddy.setLastName("Coolio");
            eddy.setAddress("3323 Leep Lane");
            eddy.setCity("Springfield");
            eddy.setPhone("5556547789");

            Pet constanzo = new Pet();
            constanzo.setName("Constanzo");
            constanzo.setPetType(savedDogPetType);
            constanzo.setBirthDate(LocalDate.now());
            constanzo.setOwner(eddy);
            eddy.getPets().add(constanzo);

            ownerService.save(eddy);

            Visit constanzoVisit = new Visit();
            constanzoVisit.setDate(LocalDate.now());
            constanzoVisit.setPet(constanzo);
            constanzoVisit.setDescription("Appointment for ticks/fleas.");

            visitService.save(constanzoVisit);

            Owner laura = new Owner();
            laura.setFirstName("Laura");
            laura.setLastName("Faye");
            laura.setAddress("3323 Leep Lane");
            laura.setCity("Springfield");
            laura.setPhone("5557003177");

            Pet sheela = new Pet();
            sheela.setName("Sheela");
            sheela.setPetType(savedCatPetType);
            sheela.setBirthDate(LocalDate.now());
            sheela.setOwner(laura);
            laura.getPets().add(sheela);

            ownerService.save(laura);

            System.out.println("Owners Loaded DONE ------------------");

            Vet vet1 = new Vet();
            vet1.setFirstName("Melinda");
            vet1.setLastName("Crosby");
            vet1.getSpecialties().add(savedDentistrySpecialty);

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstName("Teisha");
            vet2.setLastName("Lynn");
            vet2.getSpecialties().add(savedRadiologySpecialty);

            vetService.save(vet2);

            System.out.println("Vets Loaded DONE ------------------");
        }
    }
