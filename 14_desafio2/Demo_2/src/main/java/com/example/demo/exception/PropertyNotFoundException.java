package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ProductException{
    public PropertyNotFoundException(Integer id) {
        super("No se encuentra una propiedad con el id " + id, HttpStatus.NOT_FOUND);
    }
}
