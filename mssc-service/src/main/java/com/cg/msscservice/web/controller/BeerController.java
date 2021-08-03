package com.cg.msscservice.web.controller;

import com.cg.msscservice.services.BeerService;
import com.cg.msscservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beer){
        return new ResponseEntity<>(beerService.saveNewBeer(beer), HttpStatus.CREATED);
    }


    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @Validated @RequestBody BeerDto beer){
        return new ResponseEntity<>(beerService.updateBeer(beerId, beer), HttpStatus.NO_CONTENT);
    }
}
