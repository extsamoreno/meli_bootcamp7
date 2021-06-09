package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InexistentOrderException extends OrderException{
    public InexistentOrderException(String order) {
        super("El orden " + order + " no corresponde a un tipo de orden especificado.", HttpStatus.BAD_REQUEST);
    }
}
