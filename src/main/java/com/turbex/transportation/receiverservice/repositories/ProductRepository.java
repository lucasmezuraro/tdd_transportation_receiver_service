package com.turbex.transportation.receiverservice.repositories;

import com.turbex.transportation.receiverservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
