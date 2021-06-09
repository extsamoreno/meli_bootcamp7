package com.spring.desafioSpring.Exceptions;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ObjectException{
    public PropertyNotFoundException(String key) {
        super("La property: " + key + "no fue encontrada", HttpStatus.CONFLICT);
    }
}
