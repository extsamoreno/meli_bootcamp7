package com.meli.desafio2.web.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class DistrictAlreadyExistException extends DistrictException{
    public DistrictAlreadyExistException(String message, HttpStatus status) {
        super(Map.of("Distrito inválido","El distrito " + message + " ya existe."),status);
    }
}
