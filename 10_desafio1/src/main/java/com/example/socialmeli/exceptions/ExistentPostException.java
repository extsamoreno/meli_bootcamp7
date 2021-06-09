package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentPostException extends PostException{
    public ExistentPostException(String postId) {
        super("La publicación con ID " + postId + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
