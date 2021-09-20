package com.cg.petpalace.services.map;

import com.cg.petpalace.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {

    OwnerServiceMapImpl ownerService;
    final Long ownerId = 1L;
    final String ownerLastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMapImpl(new PetTypeServiceMapImpl(), new PetServiceMapImpl());
        ownerService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerService.findByLastName(ownerLastName);
        assertNotNull(foundOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner ownerFoundById = ownerService.findById(ownerId);
        assertNotNull(ownerFoundById);
    }

    @Test
    void saveNewOwner() {
        Long id = 2L;
        Owner newOwner = ownerService.save(new Owner().builder().id(id).build());
        assertEquals(id, newOwner.getId());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        assertNull(ownerService.findById(ownerId));
    }

    @Test
    void deleteExistingOwner() {
        Owner existingOwner = ownerService.findById(ownerId);
        assertNotNull(existingOwner);
        ownerService.delete(existingOwner);
        assertNull(ownerService.findById(ownerId));

    }
}