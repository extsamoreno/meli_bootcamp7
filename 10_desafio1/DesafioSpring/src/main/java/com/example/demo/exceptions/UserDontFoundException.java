package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserDontFoundException extends ResponseException{
    public UserDontFoundException(int userId) {
        super("El usuario con id "+ userId +" no existe", HttpStatus.BAD_REQUEST);
    }
}
