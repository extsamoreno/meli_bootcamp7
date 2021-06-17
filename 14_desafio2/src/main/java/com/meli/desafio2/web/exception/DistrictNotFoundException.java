package com.meli.desafio2.web.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class DistrictNotFoundException extends DistrictException{
    public DistrictNotFoundException(String message, HttpStatus status) {
        super(Map.of("Distrito inválido","El distrito " + message + " no existe."),status);
    }
}
