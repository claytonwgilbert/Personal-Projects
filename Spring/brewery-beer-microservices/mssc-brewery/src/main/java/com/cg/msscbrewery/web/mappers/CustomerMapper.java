package com.cg.msscbrewery.web.mappers;

import com.cg.msscbrewery.domain.Customer;
import com.cg.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
