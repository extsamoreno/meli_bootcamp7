package com.example.LinkTracker.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException{
    public InvalidLinkException(String link) {
        super("El link " + link + " no es válido :(", HttpStatus.BAD_REQUEST);
    }
}