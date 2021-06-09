package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidOrderException extends ApiException {
    public InvalidOrderException(String order) {
        super("The way" + order + " is not valid.", HttpStatus.BAD_REQUEST);
    }
}
