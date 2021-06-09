package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserDoesntExistException extends ResponseException{
    public UserDoesntExistException(int userId) {
        super("El usuario con id "+ userId +" no existe", HttpStatus.BAD_REQUEST);
    }
}
