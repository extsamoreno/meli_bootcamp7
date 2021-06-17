package com.meli.desafio2.web.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class PropertyAlreadyExistException extends PropertyException{
    public PropertyAlreadyExistException(String message, HttpStatus status) {
        super(Map.of("Propiedad inválida","La propiedad " + message + " ya existe."),status);
    }
}
