package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.services.ReceiverService;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ReceiverController {

    @Autowired
    ReceiverService receiverService;

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

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Valid @RequestBody DemandDTO demandDTO) throws Exception {
        Demand demand = receiverService.create(demandDTO);
        return ResponseEntity.ok(demand);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody DemandDTO demandDTO) {
        Demand demand = receiverService.update(id, demandDTO);
        return new ResponseEntity<Object>(demand, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> find(@PathVariable("id") Long id) {
        Demand demand = receiverService.findOne(id);
        System.out.println(demand.toString());
        return new ResponseEntity<Object>(demand, HttpStatus.FOUND);
    }

}
