package com.cg.msscbrewery.web.controller.v2;

import com.cg.msscbrewery.services.BeerService;
import com.cg.msscbrewery.services.v2.BeerServiceV2Impl;
import com.cg.msscbrewery.web.model.BeerDto;
import com.cg.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@Slf4j
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2Impl beerService;

    public BeerControllerV2(BeerServiceV2Impl beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beer) {
        BeerDtoV2 savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location - ", "/api/v2/beer/" + savedBeer.toString());

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 beer) {
        beerService.updateBeer(beerId, beer);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID beerId) {
        beerService.deleteBeer(beerId);
    }

}
