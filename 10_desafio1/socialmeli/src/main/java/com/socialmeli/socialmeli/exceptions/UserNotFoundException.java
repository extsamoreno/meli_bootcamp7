package com.socialmeli.socialmeli.exceptions;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException{
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}