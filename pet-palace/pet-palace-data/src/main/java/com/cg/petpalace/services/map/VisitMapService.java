package com.cg.petpalace.services.map;

import com.cg.petpalace.model.Visit;
import com.cg.petpalace.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractBaseMap<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
                || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Error. Invalid visit.");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
