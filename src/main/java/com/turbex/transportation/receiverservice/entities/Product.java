package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Demand demand;
}
