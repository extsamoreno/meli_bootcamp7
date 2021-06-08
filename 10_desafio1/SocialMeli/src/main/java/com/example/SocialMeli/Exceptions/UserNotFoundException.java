package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(String UserId) {
        super("User: "+UserId+" not found", HttpStatus.BAD_REQUEST);
    }
}
