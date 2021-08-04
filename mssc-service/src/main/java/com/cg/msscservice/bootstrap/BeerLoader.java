package com.cg.msscservice.bootstrap;

import com.cg.msscservice.domain.Beer;
import com.cg.msscservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//@Component Not using this, using sql scripts to initialize data instead
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

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
