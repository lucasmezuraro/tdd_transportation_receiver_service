package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    Product product;

    @BeforeEach
    public void init() {
        product = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
    }

    @Test
    public void mustExists() {
        Assert.assertNotNull(productService);
    }

    @Test
    public void findAProduct() {
        Long id = Long.decode("1");
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));
        Product productReceived = productService.findById(id);
        Assert.assertEquals(product.getDescription(), productReceived.getDescription());
    }
}
