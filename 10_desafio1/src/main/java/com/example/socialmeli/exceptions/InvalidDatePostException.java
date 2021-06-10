package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidDatePostException extends PostException{
    public InvalidDatePostException() {
        super("No se puede realizar una publicación de un día después de hoy", HttpStatus.BAD_REQUEST);
    }
}
