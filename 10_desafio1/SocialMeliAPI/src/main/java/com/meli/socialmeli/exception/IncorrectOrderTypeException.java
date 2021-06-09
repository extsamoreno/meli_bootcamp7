package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class IncorrectOrderTypeException extends UserException{
    public IncorrectOrderTypeException(String order){
        super("The order specified as "+order+" does not exist", HttpStatus.BAD_REQUEST);
    }
}
