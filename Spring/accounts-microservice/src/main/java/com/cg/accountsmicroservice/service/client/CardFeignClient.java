package com.cg.accountsmicroservice.service.client;

import com.cg.accountsmicroservice.model.Cards;
import com.cg.accountsmicroservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
    @FeignClient("cards") //Must match name of microservice application name within properties file of said microservice
    public interface CardFeignClient {
        @RequestMapping(method = RequestMethod.POST, value = "myCards", consumes = "application/json")
        List<Cards> getCardDetails(@RequestHeader("cg-correlation-id") String correlationId, @RequestBody Customer customer);
    }

