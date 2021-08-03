package com.cg.msscservice.services;

import com.cg.msscservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);
    
    BeerDto saveNewBeer(BeerDto beer);

    BeerDto updateBeer(UUID beerId, BeerDto beer);
}
