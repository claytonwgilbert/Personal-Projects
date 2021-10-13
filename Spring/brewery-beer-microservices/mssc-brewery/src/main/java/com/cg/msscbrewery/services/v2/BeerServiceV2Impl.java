package com.cg.msscbrewery.services.v2;

import com.cg.msscbrewery.services.BeerService;
import com.cg.msscbrewery.web.model.BeerDto;
import com.cg.msscbrewery.web.model.v2.BeerDtoV2;
import com.cg.msscbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("One of a KIND")
                .beerStyle(BeerStyleEnum.IPA)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beer) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beer) {
        //todo
    }

    @Override
    public void deleteBeer(UUID beerId) {
        //todo
    }
}
