package com.example.linktracker.exception;

import org.springframework.http.HttpStatus;

public class LinkIncorrectPasswordException extends LinkException{

    public LinkIncorrectPasswordException() {
        super("ERROR: incorrect password", HttpStatus.NOT_ACCEPTABLE);
    }
}
