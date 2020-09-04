package com.turbex.transportation.receiverservice.dtos;

import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.types.DispatchType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandDTO {
    @NotNull(message = "demand transaction must be defined")
    private UUID demandTransactionId;
    @NotNull(message = "products must be defined")
    private List<Product> products;
    @NotNull(message = "dispatch type transaction must be defined")
    private DispatchType dispatchType;
    @NotNull(message = "partner id transaction must be defined")
    private Long partnerId;
}
