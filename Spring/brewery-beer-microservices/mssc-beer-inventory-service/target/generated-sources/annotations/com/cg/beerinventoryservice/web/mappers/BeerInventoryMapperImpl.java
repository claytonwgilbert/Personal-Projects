package com.cg.beerinventoryservice.web.mappers;

import com.cg.beerinventoryservice.domain.BeerInventory;
import com.cg.brewery.model.BeerInventoryDto;

import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-10-20T02:49:55-0400",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class BeerInventoryMapperImpl implements BeerInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO) {
        if (beerInventoryDTO == null) {
            return null;
        }

        BeerInventory beerInventory = new BeerInventory();

        beerInventory.setId(beerInventoryDTO.getId());
        beerInventory.setCreatedDate(dateMapper.asTimestamp(beerInventoryDTO.getCreatedDate()));
        beerInventory.setLastModifiedDate(dateMapper.asTimestamp(beerInventoryDTO.getLastModifiedDate()));
        beerInventory.setBeerId(beerInventoryDTO.getBeerId());
        beerInventory.setQuantityOnHand(beerInventoryDTO.getQuantityOnHand());

        return beerInventory;
    }

    @Override
    public BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory) {
        if (beerInventory == null) {
            return null;
        }

        BeerInventoryDto beerInventoryDto = new BeerInventoryDto();

        beerInventoryDto.setId(beerInventory.getId());
        beerInventoryDto.setCreatedDate(dateMapper.asOffsetDateTime(beerInventory.getCreatedDate()));
        beerInventoryDto.setLastModifiedDate(dateMapper.asOffsetDateTime(beerInventory.getLastModifiedDate()));
        beerInventoryDto.setBeerId(beerInventory.getBeerId());
        beerInventoryDto.setQuantityOnHand(beerInventory.getQuantityOnHand());

        return beerInventoryDto;
    }
}
