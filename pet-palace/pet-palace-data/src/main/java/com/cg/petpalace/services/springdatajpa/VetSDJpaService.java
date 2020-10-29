package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Vet;
import com.cg.petpalace.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    @Override
    public Set<Vet> findAll() {
        return null;
    }

    @Override
    public Vet findById(Long aLong) {
        return null;
    }

    @Override
    public Vet save(Vet object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Vet vet) {

    }
}
