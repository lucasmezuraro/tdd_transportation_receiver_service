package com.turbex.transportation.receiverservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.helpers.ConverterParameters;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ReceiverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ReceiverController receiverController;
    
    private DemandDTO demandDTO;
    
    @Before("")
    public void init() {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID demandTransactionId = UUID.randomUUID();
        DispatchType dispatchType = DispatchType.NORMAL;
        Long partnerId = Long.decode("1");
        demandDTO = new DemandDTO(demandTransactionId,products, dispatchType, partnerId);
    }

    @Test()
    public void controllerMustExists() {
        Assert.notNull(receiverController, "");
    }
    @Test
    public void mustValidARequest() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ConverterParameters.converterToJson(demandDTO)))
                .andExpect(result -> ConverterParameters.converterToJson(demandDTO));
    }
}
