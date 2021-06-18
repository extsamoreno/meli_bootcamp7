package com.desafio2.Exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {

    public PropertyNotFoundException(String name) {
        super("Property with name " + name + " not found.", HttpStatus.NOT_FOUND);
    }
}
