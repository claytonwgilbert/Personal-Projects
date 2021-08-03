package com.cg.msscservice.web.controller;

import com.cg.msscservice.bootstrap.BeerLoader;
import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.services.BeerService;
import com.cg.msscservice.web.model.BeerDto;
import com.cg.msscservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() {
    }

    @Test
    void saveNewBeer() throws Exception{
        BeerDto beer = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beer);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beer  = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beer);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    private BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("Mango Bobs")
                .beerStyle(BeerStyleEnum.IPA)
                .upc(BeerLoader.BEER_1_UPC)
                .price(new BigDecimal("11.95"))
                .build();
    }
}