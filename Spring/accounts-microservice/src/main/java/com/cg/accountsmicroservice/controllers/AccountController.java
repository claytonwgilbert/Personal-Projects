package com.cg.accountsmicroservice.controllers;

import com.cg.accountsmicroservice.config.AccountServiceConfig;
import com.cg.accountsmicroservice.model.*;
import com.cg.accountsmicroservice.repositories.AccountRepository;
import com.cg.accountsmicroservice.service.client.CardFeignClient;
import com.cg.accountsmicroservice.service.client.LoanFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private AccountRepository accountsRepository;
    private AccountServiceConfig accountServiceConfig;
    private CardFeignClient cardFeignClient;
    private LoanFeignClient loanFeignClient;

    public AccountController(AccountRepository accountsRepository, AccountServiceConfig accountServiceConfig, CardFeignClient cardFeignClient, LoanFeignClient loanFeignClient) {
        this.accountsRepository = accountsRepository;
        this.accountServiceConfig = accountServiceConfig;
        this.cardFeignClient = cardFeignClient;
        this.loanFeignClient = loanFeignClient;
    }

    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer) {
        Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

    //Retrieving config properties from config server
    @GetMapping("/accounts/properties")
    public String getPropertyDetails() throws JsonProcessingException {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
                    accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
            String jsonStr = ow.writeValueAsString(properties);
            return jsonStr;
    }

    @PostMapping("/myCustomerDetails")
    @CircuitBreaker(name = "retryForCustomerDetails", fallbackMethod = "defaultCustomerDetailsFallback") //Name must also match in application.properties file
    //@Retry(name = "defaultCustomerDetails", fallbackMethod = "defaultCustomerDetailsFallback") //Name must also match in application.properties file
    public CustomerDetails myCustomerDetails(@RequestHeader("cg-correlation-id") String correlationId, @RequestBody Customer customer) {
        Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loanFeignClient.getLoanDetails(correlationId, customer);
        List<Cards> cards = cardFeignClient.getCardDetails(correlationId, customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);

        return customerDetails;
    }

    //Circuit breaker fallback method, doesn't return cards in this implementation as that is the problem service in this simulation
    private CustomerDetails defaultCustomerDetailsFallback(@RequestHeader("cg-correlation-id") String correlationId, Customer customer, Throwable t){
        Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loanFeignClient.getLoanDetails(correlationId, customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);

        return customerDetails;
    }
}
