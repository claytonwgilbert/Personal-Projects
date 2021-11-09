package com.cg.beerorderservice.sm.actions;

import com.cg.beerorderservice.config.JmsConfig;
import com.cg.beerorderservice.domain.BeerOrder;
import com.cg.beerorderservice.domain.BeerOrderEventEnum;
import com.cg.beerorderservice.services.BeerOrderManagerImpl;
import com.cg.beerorderservice.web.mappers.BeerOrderMapper;
import com.cg.brewery.model.events.AllocateOrderRequest;
import org.springframework.stereotype.Component;
import com.cg.beerorderservice.domain.BeerOrderStatusEnum;
import com.cg.beerorderservice.repositories.BeerOrderRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final JmsTemplate jmsTemplate;
    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
        String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(UUID.fromString(beerOrderId));

        beerOrderOptional.ifPresentOrElse(beerOrder -> {
            jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE,
                    AllocateOrderRequest.builder()
                            .beerOrderDto(beerOrderMapper.beerOrderToDto(beerOrder))
                            .build());
            log.debug("Sent Allocation Request for order id: " + beerOrderId);
        }, () -> log.error("Beer Order Not Found!"));
    }
}
