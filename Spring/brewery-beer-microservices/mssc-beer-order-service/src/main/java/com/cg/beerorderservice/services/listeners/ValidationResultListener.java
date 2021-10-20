package com.cg.beerorderservice.services.listeners;

import com.cg.beerorderservice.config.JmsConfig;
import com.cg.beerorderservice.services.BeerOrderManager;
import com.cg.brewery.model.events.ValidateOrderRequest;
import com.cg.brewery.model.events.ValidateOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class ValidationResultListener {

    private final BeerOrderManager beerOrderManager;

    // - Here we listen to the queue message sent back from the beer service after validating order
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE)
    public void listen(ValidateOrderResult validateOrderResult){
        // - Get the orderId from validation result object
        final UUID beerOrderId = validateOrderResult.getOrderId();

        log.debug("Validation result for Order ID: " + beerOrderId);

        // - Process the validation result using beerOrderManager
        beerOrderManager.processValidationResult(beerOrderId, validateOrderResult.getIsValid());
    }
}
