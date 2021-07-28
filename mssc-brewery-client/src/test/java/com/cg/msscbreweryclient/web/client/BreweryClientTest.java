package com.cg.msscbreweryclient.web.client;

import com.cg.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    public void testSaveNewBeer() {
        BeerDto beer = BeerDto.builder().beerName("Dark Lager").build();
        URI uri = client.saveNewBeer(beer);

        assertNotNull(uri);
    }

    @Test
    public void testUpdateBeer() {
        BeerDto beer = BeerDto.builder().beerName("Dark Lager").build();
        client.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    public void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }



}