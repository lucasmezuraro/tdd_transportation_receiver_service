package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {


    public Demand create(DemandDTO demandDTO) {
        return new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
    }
}
