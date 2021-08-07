package com.cg.msscservice.services;

import com.cg.msscservice.web.model.BeerDto;
import com.cg.msscservice.web.model.BeerPagedList;
import com.cg.msscservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);
    
    BeerDto saveNewBeer(BeerDto beer);

    BeerDto updateBeer(UUID beerId, BeerDto beer);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}
