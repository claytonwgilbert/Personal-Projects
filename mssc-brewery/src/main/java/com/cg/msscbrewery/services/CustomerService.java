package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID uuid);
}
