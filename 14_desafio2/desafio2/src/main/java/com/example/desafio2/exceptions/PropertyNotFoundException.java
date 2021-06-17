package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {
    public PropertyNotFoundException(int propertyId) {
        super("La propiedad con id: " + propertyId + " no se puede encontrar.", HttpStatus.BAD_REQUEST);
    }
}
