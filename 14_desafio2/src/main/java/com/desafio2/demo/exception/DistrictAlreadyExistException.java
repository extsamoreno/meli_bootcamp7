package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class DistrictAlreadyExistException extends PropertyException {
    public DistrictAlreadyExistException(String name) {
        super("El barrio " + name + " ya existe.", HttpStatus.BAD_REQUEST);
    }
}