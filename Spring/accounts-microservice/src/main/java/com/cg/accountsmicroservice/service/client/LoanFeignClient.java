package com.cg.accountsmicroservice.service.client;

import com.cg.accountsmicroservice.model.Cards;
import com.cg.accountsmicroservice.model.Customer;
import com.cg.accountsmicroservice.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")  //Must match name of microservice application name within properties file of said microservice
public interface LoanFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "myLoans", consumes = "application/json")
    List<Loans> getLoanDetails(@RequestHeader("cg-correlation-id") String correlationId, @RequestBody Customer customer);
}

