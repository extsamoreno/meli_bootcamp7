package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionNotFound extends UserException{
    public UserExceptionNotFound(int userId) {
        super("User with id: ".concat(Integer.toString(userId).concat(" don't exists")), HttpStatus.BAD_REQUEST);
    }
}
