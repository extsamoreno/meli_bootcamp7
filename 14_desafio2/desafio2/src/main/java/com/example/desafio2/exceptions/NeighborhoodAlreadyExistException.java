package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class NeighborhoodAlreadyExistException extends PropertyException {
    public NeighborhoodAlreadyExistException(String name) {
        super("El barrio con nombre: " + name + " ya existe.", HttpStatus.BAD_REQUEST);
    }
}
