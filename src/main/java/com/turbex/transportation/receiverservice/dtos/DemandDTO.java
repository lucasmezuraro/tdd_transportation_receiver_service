package com.turbex.transportation.receiverservice.dtos;

import com.turbex.transportation.receiverservice.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DemandDTO {
    private UUID demandTransactionId;
    private List<Product> products;
}
