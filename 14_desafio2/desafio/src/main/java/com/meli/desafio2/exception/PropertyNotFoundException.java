package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends PropertyException {

    public PropertyNotFoundException(Long id) {
        super("La propiedad con Id " + id + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }
}
