package com.example.desafiospring.socialmeli.exception;

import org.springframework.http.HttpStatus;

/**
 * UserNotFound - 404
 */
public class UserNotFoundException extends UserException{
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}