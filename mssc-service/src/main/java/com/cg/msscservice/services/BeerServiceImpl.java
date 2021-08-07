package com.cg.msscservice.services;

import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.repositories.BeerRepository;
import com.cg.msscservice.web.controller.NotFoundException;
import com.cg.msscservice.web.mappers.BeerMapper;
import com.cg.msscservice.web.model.BeerDto;
import com.cg.msscservice.web.model.BeerPagedList;
import com.cg.msscservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasLength;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepo;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
        if(showInventoryOnHand){
            return beerMapper.beerToBeerDtoWithInventory(beerRepo.findById(beerId).orElseThrow(NotFoundException::new));

        }else{
            return beerMapper.beerToBeerDto(beerRepo.findById(beerId).orElseThrow(NotFoundException::new));
        }
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

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {

        BeerPagedList beerPagedList;
        Page<Beer> beerPage;

        if(!ObjectUtils.isEmpty(beerName) && !ObjectUtils.isEmpty(beerStyle)){
            beerPage = beerRepo.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
        }else if(ObjectUtils.isEmpty(beerName) && !ObjectUtils.isEmpty(beerStyle)){
            beerPage = beerRepo.findAllByBeerStyle(beerStyle, pageRequest);
        }else if(!ObjectUtils.isEmpty(beerName) && ObjectUtils.isEmpty(beerStyle)){
            beerPage = beerRepo.findAllByBeerName(beerName, pageRequest);
        }else{
            beerPage = beerRepo.findAll(pageRequest);
        }

        if(showInventoryOnHand){
            beerPagedList = new BeerPagedList(beerPage
                    .getContent()
                    .stream()
                    .map(beerMapper::beerToBeerDtoWithInventory)
                    .collect(Collectors.toList()),
                    PageRequest
                            .of(beerPage.getPageable().getPageNumber(),
                                    beerPage.getPageable().getPageSize()),
                    beerPage.getTotalElements());
        }else{
            beerPagedList = new BeerPagedList(beerPage
                    .getContent()
                    .stream()
                    .map(beerMapper::beerToBeerDto)
                    .collect(Collectors.toList()),
                    PageRequest
                            .of(beerPage.getPageable().getPageNumber(),
                                    beerPage.getPageable().getPageSize()),
                    beerPage.getTotalElements());
        }



        return beerPagedList;

    }
}
