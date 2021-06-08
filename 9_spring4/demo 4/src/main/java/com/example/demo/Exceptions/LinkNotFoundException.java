package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends UrlException{
    public LinkNotFoundException(int i) {
        super("No se encontro link " + i, HttpStatus.BAD_REQUEST);
    }
}
