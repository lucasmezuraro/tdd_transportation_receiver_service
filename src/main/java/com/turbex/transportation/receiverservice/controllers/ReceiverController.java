package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.services.ReceiverService;
import com.turbex.transportation.receiverservice.services.ReceiverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReceiverController {


    ReceiverService receiverService;

    @Autowired
    public void getReceiveService(ReceiverServiceImpl receiverServiceImpl) {
        this.receiverService = receiverServiceImpl;
    }

    @Cacheable(value = "DemandsAll", key = "#findAllDemands")
    @GetMapping("/")
    public ResponseEntity<List<Demand>> index() {
        List<Demand> demands = receiverService.findAll();
        return ResponseEntity.ok(demands);
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

    @Cacheable(value = "DemandFindById", key = "#findDemandById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> find(@PathVariable("id") Long id) {
        Demand demand = receiverService.findOne(id);
        return new ResponseEntity<Object>(demand, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        boolean removed = receiverService.remove(id);
        return new ResponseEntity<Object>(removed, HttpStatus.FOUND);
    }

}
