package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UrlNotValidException extends LinkException{

    public UrlNotValidException(String link) {
        super("The URL '" + link + "' is not valid ", HttpStatus.BAD_REQUEST);
    }
}
