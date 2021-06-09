package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidOrderUserException extends UserException {
    public InvalidOrderUserException(String order) {
        super("El método de ordenamiento: " + order + " es invalido.", HttpStatus.BAD_REQUEST);
    }
}
