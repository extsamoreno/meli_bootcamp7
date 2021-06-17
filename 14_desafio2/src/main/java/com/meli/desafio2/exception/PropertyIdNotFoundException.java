package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyIdNotFoundException extends PropertyException {

    public PropertyIdNotFoundException(Integer propId){
        super("Property id: " + propId + " doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
