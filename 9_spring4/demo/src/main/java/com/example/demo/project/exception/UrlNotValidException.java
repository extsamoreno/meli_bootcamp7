package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class UrlNotValidException extends UrlException {
    public UrlNotValidException(String url) {
        super("La URL: " + url + " no es valida.", HttpStatus.BAD_REQUEST);
    }
}