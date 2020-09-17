package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;

import java.util.List;

public interface ReceiverService {
    public Demand create(DemandDTO demandDTO);
    public Demand findOne(Long id);
    public Demand update(Long id, DemandDTO demandDTO);
    public boolean remove(Long id);
    public List<Demand> findAll();
}
