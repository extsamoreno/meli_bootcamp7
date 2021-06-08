package com.example.DesafioSpring.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(String UserId){
        super("User" + UserId + "Not Found", HttpStatus.BAD_REQUEST);

    }
}
