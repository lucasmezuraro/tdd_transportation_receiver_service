package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.DispatchType;
import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Demand implements Serializable {
    @NotEmpty(message = "products list must be defined on the entity")
    private List<Product> products;
    @NotEmpty(message = "demand transaction must be defined on the entity")
    private UUID demandTransactionId;
    @NotEmpty(message = "demand dispatch type must be defined on the entity")
    private DispatchType dispatchType;
    private UUID trackingTicketId = UUID.randomUUID();
    private Date receivedAt = new Date();
    private Status status = Status.PENDING;

    public Demand(List<Product> products, UUID demandTransactionId, DispatchType dispatchType) {
        this.products = products;
        this.demandTransactionId = demandTransactionId;
        this.dispatchType = dispatchType;
    }
}
