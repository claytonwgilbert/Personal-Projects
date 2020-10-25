package com.cg.petpalace.services.map;

import com.cg.petpalace.model.Specialty;
import com.cg.petpalace.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesServiceMapImpl extends AbstractBaseMap<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
