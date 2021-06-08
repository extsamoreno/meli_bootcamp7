package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdInvalidException extends ResponseException{
    public UserIdInvalidException() {
        super("El id de usuario es invalido.", HttpStatus.BAD_REQUEST);
    }
}
