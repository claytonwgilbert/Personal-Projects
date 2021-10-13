package com.cg.msscservice.services.inventory;

import java.util.UUID;

public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
