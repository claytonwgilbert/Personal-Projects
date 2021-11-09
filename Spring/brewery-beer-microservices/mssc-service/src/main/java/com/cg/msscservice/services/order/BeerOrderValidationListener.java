package com.cg.msscservice.services.order;

import com.cg.brewery.model.events.ValidateOrderRequest;
import com.cg.brewery.model.events.ValidateOrderResult;
import com.cg.msscservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator beerOrderValidator;
    private final JmsTemplate jmsTemplate;

    // - Here we listen to the queue message sent from the beer order service
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest) {
        // - Determine if beer order is valid or not
        Boolean isValid = beerOrderValidator.validateOrder(validateOrderRequest.getBeerOrder());

        // - If valid, send the results to the next queue to be processed
        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(validateOrderRequest.getBeerOrder().getId())
                        .build());
    }
}
