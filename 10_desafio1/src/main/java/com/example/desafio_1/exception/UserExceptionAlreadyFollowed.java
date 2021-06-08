package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionAlreadyFollowed extends UserException{
    public UserExceptionAlreadyFollowed(String message, HttpStatus status) {
        super(message, status);
    }
}
