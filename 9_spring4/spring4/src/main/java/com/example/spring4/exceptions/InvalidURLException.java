package com.example.spring4.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidURLException extends LinkException {
    public InvalidURLException(String url) {
        super("La URL: " + url + " no es válida.", HttpStatus.BAD_REQUEST);
    }
}
