package com.example.desafio1.exceptions.user;

import org.springframework.http.HttpStatus;

public class InvalidOrderException extends UserException {
    public InvalidOrderException(String order) {
        super("El método de ordenamiento: " + order + " es invalido.", HttpStatus.BAD_REQUEST);
    }
}
