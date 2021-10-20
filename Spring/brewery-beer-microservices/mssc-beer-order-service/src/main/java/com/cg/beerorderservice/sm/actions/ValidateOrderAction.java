package com.cg.beerorderservice.sm.actions;

import com.cg.beerorderservice.config.JmsConfig;
import com.cg.beerorderservice.domain.BeerOrder;
import com.cg.beerorderservice.domain.BeerOrderEventEnum;
import com.cg.beerorderservice.domain.BeerOrderStatusEnum;
import com.cg.beerorderservice.repositories.BeerOrderRepository;
import com.cg.beerorderservice.web.mappers.BeerOrderMapper;
import com.cg.brewery.model.events.ValidateOrderRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import com.cg.beerorderservice.services.BeerOrderManagerImpl;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    private final JmsTemplate jmsTemplate;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
        // - Get beerId off header
        String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        // - Retrieve beerOrder from repository 
        Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(UUID.fromString(beerOrderId));
        // - If exists, we convert beer order to dto and add to JMS queue to be sent to validate order destination 
        beerOrderOptional.ifPresentOrElse(beerOrder -> {
            jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_QUEUE, ValidateOrderRequest.builder()
                    .beerOrder(beerOrderMapper.beerOrderToDto(beerOrder))
                    .build());
        }, () -> log.error("Order Not Found. Id: " + beerOrderId));

        log.debug("Sent Validation request to queue for order id " + beerOrderId);
    }
}
