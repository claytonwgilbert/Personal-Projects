package com.cg.petpalace.repositories;

import com.cg.petpalace.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
