package com.cg.msscservice.web.controller;

import com.cg.msscservice.services.BeerService;
import com.cg.msscservice.web.model.BeerDto;
import com.cg.msscservice.web.model.BeerPagedList;
import com.cg.msscservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerService beerService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value="pageNumber", required = false) Integer pageNumber,
                                                   @RequestParam(value="pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value="beerName", required = false) String beerName,
                                                   @RequestParam(value="beerStyle", required = false) BeerStyleEnum beerStyle,
                                                   @RequestParam(value="showInventoryOnHand", required = false) Boolean showInventoryOnHand){

        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }

        if(pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if(pageSize == null || pageSize < 1){
            pageSize = DEFAULT_PAGE_SIZE;
        }

        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);

        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId,
                                               @RequestParam(value="showInventoryOnHand", required = false) Boolean showInventoryOnHand){

        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }



        return new ResponseEntity<>(beerService.getById(beerId, showInventoryOnHand), HttpStatus.OK);
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
