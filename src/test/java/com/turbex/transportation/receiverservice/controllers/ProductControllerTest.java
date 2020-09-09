package com.turbex.transportation.receiverservice.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ProductController productController;


    public void mustBeExists() {
        Assert.assertNotNull("", Optional.ofNullable(productController));
    }

    @Test
    public void shouldReturnSuccess() throws Exception {
        this.mockMvc.perform(get("/product/")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status()
                        .is2xxSuccessful());
    }

    @Test
    public void shouldReturnSuccessulWhenSetParam() throws Exception {
        this.mockMvc.perform(get("/product/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status()
                .is2xxSuccessful());
    }

    @Test
    public void ShouldReturnANotFoundException() throws Exception {
        this.mockMvc.perform(get("/{id}", 10000))
                .andExpect(status().isNotFound());
    }

}
