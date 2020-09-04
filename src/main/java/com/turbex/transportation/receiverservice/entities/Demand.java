package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.DispatchType;
import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Demand {
    @NonNull
    private List<Product> products;
    @NonNull
    private UUID demandTransactionId;
    @NonNull
    private DispatchType dispatchType;
    private UUID trackingTicketId = UUID.randomUUID();
    private Date receivedAt = new Date();
    private Status status = Status.PENDING;
}
