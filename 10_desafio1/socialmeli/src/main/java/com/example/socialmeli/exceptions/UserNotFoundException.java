package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialException{
    public UserNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
