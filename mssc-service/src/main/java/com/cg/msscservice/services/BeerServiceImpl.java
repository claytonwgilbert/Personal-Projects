package com.cg.msscservice.services;

import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.repositories.BeerRepository;
import com.cg.msscservice.web.controller.NotFoundException;
import com.cg.msscservice.web.mappers.BeerMapper;
import com.cg.msscservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepo;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepo.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return beerMapper.beerToBeerDto(beerRepo.save(beerMapper.beerDtoToBeer(beer)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beer) {
        Beer beerToUpdate = beerRepo.findById(beerId).orElseThrow(NotFoundException::new);
        beerToUpdate.setBeerName(beer.getBeerName());
        beerToUpdate.setBeerStyle(beer.getBeerStyle().name());
        beerToUpdate.setPrice(beer.getPrice());
        beerToUpdate.setUpc(beer.getUpc());

        return beerMapper.beerToBeerDto(beerRepo.save(beerToUpdate));
    }
}
