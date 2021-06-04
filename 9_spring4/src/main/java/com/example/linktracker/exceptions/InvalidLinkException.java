package com.example.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException{
    public InvalidLinkException(String link) {
        super("El link " + link + " no es válido :(", HttpStatus.BAD_REQUEST);
    }
}
