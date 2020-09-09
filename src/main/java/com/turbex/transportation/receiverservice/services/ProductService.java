package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.exceptions.ProductNotFoundException;
import com.turbex.transportation.receiverservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: "+id+" is not found"));
    }
}
