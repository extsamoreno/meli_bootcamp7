package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException{
    public UserNotFoundException(Integer userId) {
        super("El usuario con ID " + userId + " no existe", HttpStatus.BAD_REQUEST);
    }
}
