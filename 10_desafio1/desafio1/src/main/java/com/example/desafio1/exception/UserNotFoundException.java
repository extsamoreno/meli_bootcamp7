package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException  extends UserException{
    public UserNotFoundException(int userId)
    {
        super("The id: " + userId + ". Does not match to any existent user.", HttpStatus.BAD_REQUEST);
    }
}
