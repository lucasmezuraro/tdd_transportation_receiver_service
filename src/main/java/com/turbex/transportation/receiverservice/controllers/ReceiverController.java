package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ReceiverController {
    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Está funcionando");
    }

    @PostMapping("/")
    public ResponseEntity<DemandDTO> create(@Validated @RequestBody DemandDTO demandDTO) {
        return ResponseEntity.ok(demandDTO);
    }
}
