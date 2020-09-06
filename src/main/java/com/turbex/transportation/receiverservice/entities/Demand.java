package com.turbex.transportation.receiverservice.entities;

import com.turbex.transportation.receiverservice.types.DispatchType;
import com.turbex.transportation.receiverservice.types.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "demand")
@NoArgsConstructor
public class Demand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "products list must be defined on the entity")
    @Column(name = "products")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "demand_id")
    private List<Product> products;
    @Column
    private UUID demandTransactionId;
    @Column
    private DispatchType dispatchType;
    @Column
    private UUID trackingTicketId = UUID.randomUUID();
    @Column
    private Date receivedAt = new Date();
    @Column
    private Status status = Status.PENDING;

    public Demand(List<Product> products, UUID demandTransactionId, DispatchType dispatchType) {
        this.products = products;
        this.demandTransactionId = demandTransactionId;
        this.dispatchType = dispatchType;
    }
}
