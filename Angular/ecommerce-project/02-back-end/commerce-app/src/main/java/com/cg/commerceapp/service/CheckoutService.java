package com.cg.commerceapp.service;

import com.cg.commerceapp.dto.Purchase;
import com.cg.commerceapp.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
