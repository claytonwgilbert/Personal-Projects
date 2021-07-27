package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                      .beerName("One of a KIND")
                      .beerStyle("IPA")
                      .build();
    }
}
