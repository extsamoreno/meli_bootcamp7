package com.linktracker.linktracker.exceptions;
import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException{
    public InvalidLinkException(String link) {
        super("el "+ link + " no es correcto",HttpStatus.CONFLICT);
    }
}
