package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {
    public PropertyNotFoundException(int propertyId) {
        super("The property with the ID: " + propertyId + " could not be found.", HttpStatus.BAD_REQUEST);
    }
}

