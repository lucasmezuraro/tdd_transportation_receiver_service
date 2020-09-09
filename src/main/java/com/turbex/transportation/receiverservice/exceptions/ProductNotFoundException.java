package com.turbex.transportation.receiverservice.exceptions;

import com.turbex.transportation.receiverservice.entities.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
