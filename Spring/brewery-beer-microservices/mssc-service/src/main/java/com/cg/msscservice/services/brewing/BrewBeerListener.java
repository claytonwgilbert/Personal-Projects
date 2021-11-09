package com.cg.msscservice.services.brewing;

import com.cg.msscservice.config.JmsConfig;
import com.cg.msscservice.domain.Beer;
import com.cg.brewery.model.events.BrewBeerEvent;
import com.cg.brewery.model.events.NewInventoryEvent;
import com.cg.msscservice.repositories.BeerRepository;
import com.cg.brewery.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrewBeerListener { // - Listener that brews the beer before sending out a new inventory event

    private final BeerRepository beerRepo;
    private final JmsTemplate jmsTemplate;

    // - What were listening for - sent over from BrewingService
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    @Transactional
    // - Since working with an object from the database, annotation prevents out of hibernate session errors
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();
        // - Getting beer from repo since beerDto does not have the quantityToBrew property exposed, which is the amount of
        //beer we want to brew
        Beer beer = beerRepo.getById(beerDto.getId());
        // - "Brewing the new beer"
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer - " + beer.getMinOnHand() + ": QOH - " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.INVENTORY_REQUEST_QUEUE, newInventoryEvent);
    }
}
