package com.tucasita.tasaciones.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {

    public PropertyNotFoundException(int id) {
        super("Property with id " + id + " not found", HttpStatus.BAD_REQUEST);
    }
}
