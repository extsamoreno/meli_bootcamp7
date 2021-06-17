package com.meli.desafio2.exception;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends PropertyException {
    public DistrictNotFoundException(String name) {
            super("El barrio " + name + " no se encuetra registrado.", HttpStatus.NOT_FOUND);
    }
}
