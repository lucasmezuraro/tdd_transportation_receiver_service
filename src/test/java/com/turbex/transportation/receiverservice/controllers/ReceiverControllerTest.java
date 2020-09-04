package com.turbex.transportation.receiverservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ReceiverControllerTest {

    @Autowired
    ReceiverController receiverController;

    @Test()
    public void controllerMustExists() {
        Assert.notNull(receiverController, "Está funcionando");
    }
}
