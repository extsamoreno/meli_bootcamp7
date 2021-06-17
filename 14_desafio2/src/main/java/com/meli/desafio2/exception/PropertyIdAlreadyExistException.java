package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyIdAlreadyExistException extends PropertyException {

    public PropertyIdAlreadyExistException(Integer propId) {
        super("The Property Id " + propId + " already exists", HttpStatus.BAD_REQUEST);
    }
}
