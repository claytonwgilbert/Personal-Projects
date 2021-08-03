package com.cg.msscservice.bootstrap;

import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "00155001541002";
    public static final String BEER_2_UPC = "00433001791012";

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
                              .upc(BEER_1_UPC)
                              .price(new BigDecimal("11.95"))
                              .build());

            beerRepo.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
        System.out.println("Loaded beers:" + beerRepo.count());
    }
}
