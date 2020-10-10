package com.cg.petpalace.services.map;

import com.cg.petpalace.model.Pet;
import com.cg.petpalace.services.PetService;

import java.util.Set;

public class PetServiceMapImpl extends AbstractBaseMap<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
