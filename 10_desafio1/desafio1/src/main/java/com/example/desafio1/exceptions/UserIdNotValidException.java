package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdNotValidException extends ResponseException{
    public UserIdNotValidException(int id){
        super("User ID " + id + " is NOT valid.", HttpStatus.BAD_REQUEST);
    }
}
