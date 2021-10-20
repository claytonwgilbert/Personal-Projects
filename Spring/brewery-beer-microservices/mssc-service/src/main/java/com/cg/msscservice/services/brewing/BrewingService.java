package com.cg.msscservice.services.brewing;

import com.cg.msscservice.config.JmsConfig;
import com.cg.msscservice.domain.Beer;
import com.cg.brewery.model.events.BrewBeerEvent;
import com.cg.msscservice.repositories.BeerRepository;
import com.cg.msscservice.services.inventory.BeerInventoryService;
import com.cg.msscservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService inventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper mapper;

    @Scheduled(fixedRate = 5000) // - Every 5 seconds
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = inventoryService.getOnhandInventory(beer.getId());
            log.debug("Min on hand:" + beer.getMinOnHand());
            log.debug("Inventory:" + invQOH);

            // - If condition is true, need more inventory, so we create new brew beer event and send the request
            if(beer.getMinOnHand() >= invQOH){
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(mapper.beerToBeerDto(beer)));
            }
        });
    }
}
