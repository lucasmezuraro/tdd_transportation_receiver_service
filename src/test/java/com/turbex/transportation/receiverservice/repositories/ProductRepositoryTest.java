package com.turbex.transportation.receiverservice.repositories;

import com.turbex.transportation.receiverservice.entities.Product;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void init() {
        product = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
    }

    @Test
    public void createAProduct() {

        Product productSaved = productRepository.save(product);
        Assert.assertEquals(product.getDescription(), productSaved.getDescription());
    }

    @Test
    public void deleteAProduct() {
        Product productSaved = productRepository.save(product);
        productRepository.delete(productSaved);
        Optional<Product> productAfterDeleted = productRepository.findById(productSaved.getId());
        Assert.assertFalse(productAfterDeleted.isPresent());
    }

    @Test
    public void updateAProduct() {
        Product productSaved = productRepository.save(product);
        Product productToUpdate = productRepository.findById(productSaved.getId()).get();
        productToUpdate.setDescription("CellPhone");
        productRepository.save(productToUpdate);
        Product productUpdated = productRepository.findById(productSaved.getId()).get();
        Assert.assertEquals("CellPhone", productUpdated.getDescription());
    }
}
