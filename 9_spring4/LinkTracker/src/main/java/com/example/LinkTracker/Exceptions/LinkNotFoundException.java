package com.example.LinkTracker.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException{
    public InvalidLinkException() {
        super("invalid url", HttpStatus.BAD_REQUEST);
    }
}
