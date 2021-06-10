package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(int userId) {
        super("User: " + userId + " was not found", HttpStatus.BAD_REQUEST);
    }
}
