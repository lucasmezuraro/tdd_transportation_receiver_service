package com.turbex.transportation.receiverservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbex.transportation.receiverservice.dtos.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

    public static String converterToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test()
    public void controllerMustExists() {
        Assert.notNull(receiverController, "Está funcionando");
    }
    @Test
    public void mustValidARequest() throws Exception {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID partnerId = UUID.randomUUID();
        Demand demand = new Demand(partnerId, products);
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON).content(converterToJson(demand)))
                .andExpect(result -> converterToJson(demand));
    }
}
