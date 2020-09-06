package com.turbex.transportation.receiverservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    @Column
    private String description;
    @NonNull
    @Column
    private double width;
    @Column
    @NonNull
    private double height;
    @Column
    @NonNull
    private double depth;
    @Column
    @NonNull
    private double weight;
    @Column
    @NonNull
    private Long partnerId;
    @Column
    private Date receivedAt = new Date();
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demand_demand_id")
    @JsonIgnoreProperties("products")
    private Demand demand;*/
}
