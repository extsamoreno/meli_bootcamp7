package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class OrderErrorException extends GenericException{
    public OrderErrorException(String order) {
        super("El order " + order + " no es valido.", HttpStatus.BAD_REQUEST);
    }
}
