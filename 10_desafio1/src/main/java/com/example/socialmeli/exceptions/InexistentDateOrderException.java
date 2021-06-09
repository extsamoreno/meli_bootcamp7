package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InexistentDateOrderException extends OrderException{
    public InexistentDateOrderException(String order) {
        super("El orden " + order + " no corresponde a un tipo de orden de fecha especificado.", HttpStatus.BAD_REQUEST);
    }
}
