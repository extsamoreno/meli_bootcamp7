package com.example.desafio1.exceptions;

import org.springframework.http.HttpStatus;

public class RepeatedUsersIdException extends ResponseException{
    public RepeatedUsersIdException(){
        super("The users ID cannot be the same", HttpStatus.BAD_REQUEST);
    }
}
