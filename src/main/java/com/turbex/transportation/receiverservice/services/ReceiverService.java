package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.exceptions.DemandNotFoundException;
import com.turbex.transportation.receiverservice.repositories.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    @Autowired
    DemandRepository demandRepository;

    public Demand create(DemandDTO demandDTO) {
        Demand demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
        return demandRepository.save(demand);
    }

    public Demand findOne(Long id){
        return demandRepository.findById(id)
                .orElseThrow(() -> new DemandNotFoundException("Demand with id: "+id+" is not found"));
    }
}
