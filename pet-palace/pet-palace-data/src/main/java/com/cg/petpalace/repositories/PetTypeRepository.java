package com.cg.petpalace.repositories;

import com.cg.petpalace.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
