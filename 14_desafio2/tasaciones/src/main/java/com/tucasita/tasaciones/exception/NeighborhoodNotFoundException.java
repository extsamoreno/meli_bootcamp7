package com.tucasita.tasaciones.exception;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFoundException extends PropertyException {

    public NeighborhoodNotFoundException(String name) {
        super("No neighborhood called " + name + " found", HttpStatus.BAD_REQUEST);
    }
}
