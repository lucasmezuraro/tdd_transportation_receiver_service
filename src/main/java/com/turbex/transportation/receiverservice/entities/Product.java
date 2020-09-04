package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Product {
    @NonNull
    private String description;
    @NonNull
    private double width;
    @NonNull
    private double height;
    @NonNull
    private double depth;
    @NonNull
    private double weight;
    @NonNull
    private Long partnerId;
    private Date receivedAt = new Date();
    private Status status = Status.PENDING;
}
