package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends ResponseException{
    public LinkNotFoundException(int id) {
        super("La direccion del link con el id "+ id +" no existe.", HttpStatus.NOT_FOUND);
    }
}
