package com.desafio2.demo.exception;

import org.springframework.http.HttpStatus;

public class NeighborhoodAlreadyExistException extends PropertyException {
    public NeighborhoodAlreadyExistException(String name) {
        super("The neighborhood " + name + " already exists.", HttpStatus.BAD_REQUEST);
    }
}