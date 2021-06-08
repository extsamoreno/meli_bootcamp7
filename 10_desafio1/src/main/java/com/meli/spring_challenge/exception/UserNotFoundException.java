package com.meli.spring_challenge.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(int userID){
        super("UserID: " + userID + " Not exist!", HttpStatus.BAD_REQUEST);
    }
}
