package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InexistentUserException extends UserException{
    public InexistentUserException(int userId) {
        super("El usuario con ID " + userId + " no existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}