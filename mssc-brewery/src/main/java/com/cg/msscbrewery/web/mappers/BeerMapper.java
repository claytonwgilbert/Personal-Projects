package com.cg.msscbrewery.web.mappers;

import com.cg.msscbrewery.domain.Beer;
import com.cg.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

//Mapper will do all the data mapping between these two objects automatically for us.
//Also specifying an additional custom mapper DateMapper.class for the mapper to be used as different time data types
//are being used between the two classes.
@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerBetoToBeer(BeerDto beer);
}
