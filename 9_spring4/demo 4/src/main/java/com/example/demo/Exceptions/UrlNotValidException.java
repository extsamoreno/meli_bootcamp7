package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class UrlNotValidException extends UrlException{
    public UrlNotValidException() {
        super("Url no valida", HttpStatus.BAD_REQUEST);
    }
}
