package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findById(Long id);

}
