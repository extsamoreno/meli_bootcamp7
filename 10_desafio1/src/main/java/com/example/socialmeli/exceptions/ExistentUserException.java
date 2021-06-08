package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentUserException extends UserException{
    public ExistentUserException(String userName) {
        super("El usuario con nombre de usuario " + userName + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
