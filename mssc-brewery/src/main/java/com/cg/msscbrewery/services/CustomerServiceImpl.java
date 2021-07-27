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
}
