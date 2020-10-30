package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Pet;
import com.cg.petpalace.repositories.PetRepository;
import com.cg.petpalace.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaServiceImpl implements PetService {

    private final PetRepository petRepo;

    public PetSDJpaServiceImpl(PetRepository petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> foundPets = new HashSet<>();
        petRepo.findAll().forEach(foundPets::add);
        return foundPets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepo.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }

    @Override
    public void delete(Pet pet) {
        petRepo.delete(pet);
    }
}
