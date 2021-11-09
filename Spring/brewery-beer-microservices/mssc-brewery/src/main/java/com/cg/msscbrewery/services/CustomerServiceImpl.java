package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Clayton Gilbert")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customer) {
        //todo
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        //todo
    }
}
