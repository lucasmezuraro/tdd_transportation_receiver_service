package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ReceiverController {
    @GetMapping("/")
    public ResponseEntity<DemandDTO> index() {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID demandTransactionId = UUID.randomUUID();
        DispatchType dispatchType = DispatchType.NORMAL;
        Long partnerId = Long.decode("1");
        DemandDTO demandDTO = new DemandDTO(demandTransactionId,products, dispatchType, partnerId);
        return ResponseEntity.ok(demandDTO);
    }

    @PostMapping("/")
    public ResponseEntity<Demand> create(@RequestBody DemandDTO demandDTO) {
        Demand demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
        return ResponseEntity.ok(demand);
    }
}
