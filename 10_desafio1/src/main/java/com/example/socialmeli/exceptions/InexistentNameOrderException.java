package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InexistentNameOrderException extends OrderException{
    public InexistentNameOrderException(String order) {
        super("El orden " + order + " no corresponde a un tipo de orden de nombre especificado.", HttpStatus.BAD_REQUEST);
    }
}
