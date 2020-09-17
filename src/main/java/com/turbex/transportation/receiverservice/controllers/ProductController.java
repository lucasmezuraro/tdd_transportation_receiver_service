package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.services.ProductService;
import com.turbex.transportation.receiverservice.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    ProductService productService;

    @Autowired
    public void getProductService(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @Cacheable(value = "ProductAll", key = "#findAllProducts")
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get() {
        List<Product> productList = productService.findAll();
        return ResponseEntity.ok(productList);
    }

    @Cacheable(value = "ProductFindById", key = "#findProductById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findOne(@PathVariable("id")  Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }




}
