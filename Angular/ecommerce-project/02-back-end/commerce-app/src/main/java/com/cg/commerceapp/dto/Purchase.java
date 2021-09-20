package com.cg.commerceapp.dto;

import com.cg.commerceapp.entity.Customer;
import com.cg.commerceapp.entity.Address;
import com.cg.commerceapp.entity.Order;
import com.cg.commerceapp.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
