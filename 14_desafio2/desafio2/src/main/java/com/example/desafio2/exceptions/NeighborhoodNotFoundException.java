package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFoundException extends PropertyException {
    public NeighborhoodNotFoundException(String neighborhood) {
        super("El barrio: " + neighborhood + " no se puede encontrar.", HttpStatus.BAD_REQUEST);
    }
}
