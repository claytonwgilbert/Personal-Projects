package com.cg.accountsmicroservice.controllers;

import com.cg.accountsmicroservice.model.Account;
import com.cg.accountsmicroservice.model.Customer;
import com.cg.accountsmicroservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private AccountRepository accountsRepository;

    public AccountController(AccountRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
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

}
