package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistException extends PropertyException {
    public PropertyAlreadyExistException(String name) {
        super("La propiedad " + name + " ya existe.", HttpStatus.BAD_REQUEST);
    }
}