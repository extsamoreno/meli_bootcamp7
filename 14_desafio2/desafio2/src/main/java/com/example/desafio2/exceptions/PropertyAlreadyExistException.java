package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistException extends PropertyException {
    public PropertyAlreadyExistException(String name) {
        super("La propiedad con nombre: " + name + " ya existe.", HttpStatus.BAD_REQUEST);
    }
}
