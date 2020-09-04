package com.turbex.transportation.receiverservice.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterParameters {
    public static String converterToJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
