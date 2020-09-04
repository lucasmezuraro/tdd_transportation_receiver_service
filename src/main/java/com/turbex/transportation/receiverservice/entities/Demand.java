package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Demand {
    private List<Product> products;
    private Date receivedAt = new Date();
    private Status status = Status.PENDING;
}
