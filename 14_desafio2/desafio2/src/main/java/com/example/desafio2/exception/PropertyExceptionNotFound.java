package com.example.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyExceptionNotFound extends PropertyException {
    public PropertyExceptionNotFound(String name) {
        super("Property name: "+ name +" not found", HttpStatus.BAD_REQUEST);
    }
}
