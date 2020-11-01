package com.cg.petpalace.services.springdatajpa;

import com.cg.petpalace.model.Owner;
import com.cg.petpalace.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceImplTest {

    @Mock
    OwnerRepository ownerRepo;

    @InjectMocks
    OwnerSDJpaServiceImpl service;

    final static String LAST_NAME = "smith";
    final static Long ID = 1L;

    Owner builtOwner;

    @BeforeEach
    void setUp() {
        builtOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepo.findByLastName(any())).thenReturn(builtOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepo.findAll()).thenReturn(ownerSet);

        Set<Owner> returnedOwners = service.findAll();

        assertNotNull(returnedOwners);
        assertEquals(2, returnedOwners.size());
    }

    @Test
    void findById() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(builtOwner));

        Owner returnedOwner = service.findById(1l);

        assertNotNull(returnedOwner);
    }

    @Test
    void save() {
        Owner newOwner = Owner.builder().id(1l).build();

        when(ownerRepo.save(any())).thenReturn(builtOwner);

        Owner returnedOwner = service.save(newOwner);

        assertNotNull(returnedOwner);
    }

    @Test
    void deleteById() {
        service.delete(builtOwner);

        verify(ownerRepo).delete(any());
    }

    @Test
    void delete() {
        service.deleteById(builtOwner.getId());

        verify(ownerRepo).deleteById(anyLong());
    }
}