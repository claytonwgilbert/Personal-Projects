package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                      .beerName("One of a KIND")
                      .beerStyle("IPA")
                      .build();
    }
}
