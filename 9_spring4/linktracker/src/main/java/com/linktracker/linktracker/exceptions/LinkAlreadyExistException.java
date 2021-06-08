package com.linktracker.linktracker.exceptions;
import org.springframework.http.HttpStatus;

public class LinkAlreadyExistException extends LinkException{
    public LinkAlreadyExistException(String link) {
        super("el link"+link +" ya existe", HttpStatus.CONFLICT);
    }
}
