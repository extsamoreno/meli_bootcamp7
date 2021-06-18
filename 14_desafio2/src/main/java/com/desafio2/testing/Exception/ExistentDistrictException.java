package com.desafio2.testing.Exception;

import org.springframework.http.HttpStatus;

public class ExistentDistrictException extends PropertyException {

    public ExistentDistrictException(String name) {
        super("El barrio: "+name+" ya existe", HttpStatus.BAD_REQUEST);
    }
}
