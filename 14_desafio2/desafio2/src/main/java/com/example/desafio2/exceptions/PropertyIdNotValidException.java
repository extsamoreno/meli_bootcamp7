package com.example.desafio2.exceptions;

import org.springframework.http.HttpStatus;

public class PropertyIdNotValidException extends ResponseException{
    public PropertyIdNotValidException(int id) {
        super("Property ID " + id + " is NOT valid.", HttpStatus.BAD_REQUEST);
    }
}
