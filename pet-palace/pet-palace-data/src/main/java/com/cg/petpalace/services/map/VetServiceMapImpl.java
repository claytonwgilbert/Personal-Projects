package com.cg.petpalace.services.map;

import com.cg.petpalace.model.Specialty;
import com.cg.petpalace.model.Vet;
import com.cg.petpalace.services.SpecialtyService;
import com.cg.petpalace.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMapImpl extends AbstractBaseMap<Vet, Long> implements VetService {

    SpecialtyService specialtyService;

    public VetServiceMapImpl(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialties().size() > 0){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
