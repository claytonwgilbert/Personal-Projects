package com.cg.msscbrewery.services.v2;

import com.cg.msscbrewery.web.model.BeerDto;
import com.cg.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beer);

    void updateBeer(UUID beerId, BeerDtoV2 beer);

    void deleteBeer(UUID beerId);
}
