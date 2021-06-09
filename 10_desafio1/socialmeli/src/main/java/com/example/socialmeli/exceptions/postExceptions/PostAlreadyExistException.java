package com.example.socialmeli.exceptions.postExceptions;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistException extends PostException{
    public PostAlreadyExistException(String message, HttpStatus status) {
        super(message, status);
    }
}
