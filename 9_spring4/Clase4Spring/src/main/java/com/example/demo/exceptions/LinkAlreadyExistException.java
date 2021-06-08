package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkAlreadyExistException extends ResponseException{
    public LinkAlreadyExistException(String address) {
        super("La direccion "+ address +" ya existe.", HttpStatus.BAD_REQUEST);
    }
}
