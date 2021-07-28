package com.cg.msscbreweryclient.web.client;

import com.cg.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    public void getBeerById() {
        BeerDto beer = client.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }
}