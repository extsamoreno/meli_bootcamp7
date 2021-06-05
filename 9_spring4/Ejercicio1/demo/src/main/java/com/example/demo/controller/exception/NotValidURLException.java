package com.example.demo.controller.exception;

import org.springframework.http.HttpStatus;

public class NotValidURLException extends GenericException{

    public NotValidURLException(String url) {
        super("La URL " + url + " no es valida.", HttpStatus.BAD_REQUEST);
    }
}
