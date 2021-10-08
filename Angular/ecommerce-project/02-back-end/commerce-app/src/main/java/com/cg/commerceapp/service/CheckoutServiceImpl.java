package com.cg.commerceapp.service;

import com.cg.commerceapp.dao.CustomerRepository;
import com.cg.commerceapp.dto.Purchase;
import com.cg.commerceapp.dto.PurchaseResponse;
import com.cg.commerceapp.entity.Customer;
import com.cg.commerceapp.entity.Order;
import com.cg.commerceapp.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();
        
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(orderItem -> order.addOrderItem(orderItem));

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();

        //Get email from customer to check if he is already in db
        String customerEmail = customer.getEmail();

        Customer fromDbCustomer = customerRepository.findByEmail(customerEmail);

        if(fromDbCustomer != null){
            //Customer alreadys exists in db...set customer details from db to new order to prevent duplicate customers
            //from being added to the db while allowing new orders to still be added and assigned to this one customer
            //which is done after this if statement.
            customer = fromDbCustomer;
        }

        customer.addOrder(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
