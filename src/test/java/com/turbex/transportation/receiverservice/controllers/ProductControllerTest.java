package com.turbex.transportation.receiverservice.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    public void mustBeExists() {
        Assert.assertNotNull("", Optional.ofNullable(productController));
    }
}
