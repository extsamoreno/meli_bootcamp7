package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ResponseException{
    public UserNotFoundException(Integer id) {
        super("El usuario con el id " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}
