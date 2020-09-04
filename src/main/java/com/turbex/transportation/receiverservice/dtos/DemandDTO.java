package com.turbex.transportation.receiverservice.dtos;

import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.types.DispatchType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DemandDTO {
    private UUID demandTransactionId;
    private List<Product> products;
    private DispatchType dispatchType;
    private Long partnerId;
}
