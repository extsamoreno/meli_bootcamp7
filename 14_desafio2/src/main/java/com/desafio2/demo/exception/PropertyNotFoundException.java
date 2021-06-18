package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {
    public PropertyNotFoundException(int propertyId) {
        super("La propiedad con el id " + propertyId + " no se encuentra.", HttpStatus.BAD_REQUEST);
    }
}

