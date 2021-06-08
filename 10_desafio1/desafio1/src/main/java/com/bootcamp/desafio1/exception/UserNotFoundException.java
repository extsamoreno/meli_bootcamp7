package com.bootcamp.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(int id) {
        super("The UserID: " +id+ " is not found in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
