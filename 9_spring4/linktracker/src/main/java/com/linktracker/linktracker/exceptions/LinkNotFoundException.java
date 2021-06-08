package com.linktracker.linktracker.exceptions;
import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends LinkException{
    public LinkNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
