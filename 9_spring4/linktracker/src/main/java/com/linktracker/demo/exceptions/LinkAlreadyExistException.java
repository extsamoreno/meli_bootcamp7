package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkAlreadyExistException extends ResponseException{
    public LinkAlreadyExistException(String url) {
        super("La url "+ url +" ya existe.", HttpStatus.BAD_REQUEST);
    }
}

