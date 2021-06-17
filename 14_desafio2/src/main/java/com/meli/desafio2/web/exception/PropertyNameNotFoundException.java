package com.meli.desafio2.web.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class PropertyNameNotFoundException extends PropertyException{

    public PropertyNameNotFoundException(String message, HttpStatus status) {
        super(Map.of("Propiedad inválida","La propiedad " + message + " no existe."),status);
    }
}
