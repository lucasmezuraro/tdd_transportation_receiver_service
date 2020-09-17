package com.turbex.transportation.receiverservice.services;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.exceptions.DemandNotFoundException;
import com.turbex.transportation.receiverservice.repositories.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceiverServiceImpl implements ReceiverService {
    @Autowired
    DemandRepository demandRepository;

    @Transactional
    public Demand create(DemandDTO demandDTO) {
        Demand demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
        return demandRepository.save(demand);
    }

    public Demand findOne(Long id){
        return demandRepository.findById(id)
                .orElseThrow(() -> new DemandNotFoundException("Demand with id: "+id+" is not found"));
    }

    @Transactional
    public Demand update(Long id, DemandDTO demandDTO){
        Demand demand = demandRepository.findById(id)
                .orElseThrow(() -> new DemandNotFoundException("Demand with id: "+id+" is not found"));
        demand.setProducts(demandDTO.getProducts());
        demand.setDispatchType(demandDTO.getDispatchType());
        demand.setDemandTransactionId(demandDTO.getDemandTransactionId());
        Demand demandUpdated = demandRepository.save(demand);
        return demandUpdated;
    }

    public boolean remove(Long id){
        try {
            demandRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            throw new DemandNotFoundException("Demand with id: "+id+" is not found");
        }
    }

    public List<Demand> findAll() {
        return demandRepository.findAll();
    }
}
