package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                      .id(UUID.randomUUID())
                      .beerName("One of a KIND")
                      .beerStyle("IPA")
                      .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return BeerDto.builder()
                      .id(UUID.randomUUID())
                      .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beer) {
        //todo
    }

    @Override
    public void deleteBeer(UUID beerId) {
        //todo
    }
}
