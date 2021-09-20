package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Visit;
import com.cg.petpalace.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaServiceImpl implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return null;
    }

    @Override
    public Visit findById(Long aLong) {
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Visit visit) {

    }
}
