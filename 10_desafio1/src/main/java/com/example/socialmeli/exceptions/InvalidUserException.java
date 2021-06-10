package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidUserException extends UserException{
    public InvalidUserException() {
        super("El nombre de usuario que proporcionó no es válido por estar vacío", HttpStatus.BAD_REQUEST);
    }
}
