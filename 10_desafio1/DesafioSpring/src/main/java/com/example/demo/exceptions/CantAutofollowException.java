package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class CantAutofollowException extends ResponseException{
    public CantAutofollowException(int userId) {
        super("No es posible autoseguirse", HttpStatus.BAD_REQUEST);
    }
}
