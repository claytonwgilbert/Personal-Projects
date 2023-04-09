package com.cg.accountsmicroservice.controllers;

import com.cg.accountsmicroservice.config.AccountServiceConfig;
import com.cg.accountsmicroservice.model.Account;
import com.cg.accountsmicroservice.model.Customer;
import com.cg.accountsmicroservice.model.Properties;
import com.cg.accountsmicroservice.repositories.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private AccountRepository accountsRepository;
    private AccountServiceConfig accountServiceConfig;

    public AccountController(AccountRepository accountsRepository, AccountServiceConfig accountServiceConfig) {
        this.accountsRepository = accountsRepository;
        this.accountServiceConfig = accountServiceConfig;
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
}
