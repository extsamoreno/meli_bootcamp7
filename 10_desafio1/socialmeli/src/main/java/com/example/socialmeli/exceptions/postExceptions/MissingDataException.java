package com.example.socialmeli.exceptions.postExceptions;

import org.springframework.http.HttpStatus;

public class MissingDataException extends PostException{
    public MissingDataException(String message, HttpStatus status) {
        super(message, status);
    }
}
