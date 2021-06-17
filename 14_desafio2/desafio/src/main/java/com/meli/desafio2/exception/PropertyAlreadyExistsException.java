package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyAlreadyExistsException extends PropertyException {
    public PropertyAlreadyExistsException(Long id) {
        super("La propiedad con Id " + id + " ya se encuentra registrada.", HttpStatus.BAD_REQUEST);
    }
}
