package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(int userId){
        super("The user requested with user id "+userId+" doesnt exist", HttpStatus.BAD_REQUEST);
    }
}
