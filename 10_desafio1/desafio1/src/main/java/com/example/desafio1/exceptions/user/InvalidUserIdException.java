package com.example.desafio1.exceptions.user;

import org.springframework.http.HttpStatus;

public class InvalidUserIdException extends UserException {
    public InvalidUserIdException(int userId) {
        super("El usuario con id: " + userId + " es invalido.", HttpStatus.BAD_REQUEST);
    }
}
