package com.cg.msscservice.events;

import com.cg.msscservice.web.model.BeerDto;

public class InventoryEvent extends BeerEvent {
    public InventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
