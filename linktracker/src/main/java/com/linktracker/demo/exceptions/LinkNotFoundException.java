package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends ResponseException{
    public LinkNotFoundException(Integer id) {
        super("La url con el id "+ id +" no existe.", HttpStatus.NOT_FOUND);
    }
}
