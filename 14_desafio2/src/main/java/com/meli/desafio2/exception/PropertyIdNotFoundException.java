package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyIdNotFoundException extends PropertyException {

    public PropertyIdNotFoundException(Integer propId){
        super("ID: " + propId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
