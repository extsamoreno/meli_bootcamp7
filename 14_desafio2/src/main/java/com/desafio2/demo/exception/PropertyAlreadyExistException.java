package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistException extends PropertyException {
    public PropertyAlreadyExistException(String name) {
        super("The property " + name + " already exists.", HttpStatus.BAD_REQUEST);
    }
}