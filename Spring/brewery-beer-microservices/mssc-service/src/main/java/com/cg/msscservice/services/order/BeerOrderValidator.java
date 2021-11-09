package com.cg.msscservice.services.order;

import com.cg.brewery.model.events.BeerOrderDto;
import com.cg.msscservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrder) {
        AtomicInteger beersNotFound = new AtomicInteger();

        // - Check the orderLine object off the beer order
        beerOrder.getBeerOrderLines().forEach(orderLine -> {
            // - Check if we can find the order by upc in database...
            if (beerRepository.findByUpc(orderLine.getUpc()) == null) {
                // - If not, increment beers not found variable which will fail this validation
                beersNotFound.incrementAndGet();
            }
        });

        // - Return true to pass validation only if our beers not found variable is 0
        return beersNotFound.get() == 0;

    }
}
