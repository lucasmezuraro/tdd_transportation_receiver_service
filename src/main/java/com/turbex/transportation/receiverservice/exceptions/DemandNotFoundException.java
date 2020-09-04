package com.turbex.transportation.receiverservice.exceptions;

public class DemandNotFoundException extends RuntimeException{

    public DemandNotFoundException(String message) {
        super(message);
    }
}
