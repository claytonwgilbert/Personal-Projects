package com.cg.msscservice.bootstrap;

import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepo;

    public BeerLoader(BeerRepository beerRepo) {
        this.beerRepo = beerRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepo.count() == 0){

            beerRepo.save(Beer.builder()
                              .beerName("Mango Bobs")
                              .beerStyle("IPA")
                              .quantityToBrew(200)
                              .minOnHand(15)
                              .upc(155001541002l)
                              .price(new BigDecimal("11.95"))
                              .build());

            beerRepo.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(433001791012l)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
        System.out.println("Loaded beers:" + beerRepo.count());
    }
}
