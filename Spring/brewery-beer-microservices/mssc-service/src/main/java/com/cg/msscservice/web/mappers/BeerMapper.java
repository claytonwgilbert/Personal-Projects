package com.cg.msscservice.web.mappers;

import com.cg.msscservice.domain.Beer;
import com.cg.brewery.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beer);
    BeerDto beerToBeerDtoWithInventory(Beer beer);

}