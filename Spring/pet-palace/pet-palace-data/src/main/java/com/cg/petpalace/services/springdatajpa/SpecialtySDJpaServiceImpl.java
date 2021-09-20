package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Specialty;
import com.cg.petpalace.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaServiceImpl implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return null;
    }

    @Override
    public Specialty findById(Long aLong) {
        return null;
    }

    @Override
    public Specialty save(Specialty object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Specialty specialty) {

    }
}
