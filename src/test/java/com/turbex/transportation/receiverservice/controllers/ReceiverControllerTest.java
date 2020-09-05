package com.turbex.transportation.receiverservice.controllers;

import com.turbex.transportation.receiverservice.dtos.DemandDTO;
import com.turbex.transportation.receiverservice.entities.Demand;
import com.turbex.transportation.receiverservice.entities.Product;
import com.turbex.transportation.receiverservice.helpers.ConverterParameters;
import com.turbex.transportation.receiverservice.types.DispatchType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReceiverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    ReceiverController receiverController;
    
    private DemandDTO demandDTO;
    private Demand demand;
    private DemandDTO demandDTOError;
    
    @BeforeEach()
    public void init() {
        Product cellPhone = new Product("cellPhone", 11.0, 18.0, 4.0, 560.0, Long.decode("1"));
        List<Product> products = new ArrayList<Product>();
        products.add(cellPhone);
        UUID demandTransactionId = UUID.randomUUID();
        DispatchType dispatchType = DispatchType.NORMAL;
        Long partnerId = Long.decode("1");
        demandDTO = new DemandDTO(demandTransactionId,products, dispatchType, partnerId);

        demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());

    }

    @Test()
    public void controllerMustExists() {
        Assert.notNull(receiverController, "");
    }

    @Test
    public void demandMustHasProducts() {
        AssertionErrors.assertEquals("",demandDTO.getProducts(), demand.getProducts());
    }

    @Test
    public void mustValidARequest() throws Exception {
        demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
         this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ConverterParameters.converterToJson(demandDTO)))
                .andExpect(result -> ConverterParameters.converterToJson(demand));
    }

    @Test
    public void ShouldReturnAValidationException() throws Exception {
        demandDTOError = new DemandDTO(demandDTO.getDemandTransactionId(),  null, demandDTO.getDispatchType(), null);
        demand = new Demand(demandDTO.getProducts(), demandDTO.getDemandTransactionId(), demandDTO.getDispatchType());
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ConverterParameters.converterToJson(demandDTOError)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void ShouldReturnANotFoundException() throws Exception {
        this.mockMvc.perform(get("/{id}", 10000))
                .andExpect(status().isNotFound());
    }


}
