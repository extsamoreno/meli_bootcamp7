package com.example.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistsException extends PropertyException {
    public PropertyAlreadyExistsException(String name) {
        super("Property: "+ name +" already exist", HttpStatus.BAD_REQUEST);
    }
}