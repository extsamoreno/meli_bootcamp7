package com.tucasita.tasaciones.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {

    public PropertyNotFoundException(String message) {
        super("Property not found", HttpStatus.BAD_REQUEST);
    }
}
