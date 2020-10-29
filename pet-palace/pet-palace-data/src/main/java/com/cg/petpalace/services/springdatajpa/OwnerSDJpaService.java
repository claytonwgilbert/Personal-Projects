package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.repositories.OwnerRepository;
import com.cg.petpalace.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> foundOwners = new HashSet<>();
        //ownerRepository.findAll().forEach(owner -> foundOwners.add(owner));
        ownerRepository.findAll().forEach(foundOwners::add);
        return foundOwners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}
