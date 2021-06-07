package com.example.LinkTracker.exceptions;

import org.springframework.http.HttpStatus;


public class ExistentLinkException extends LinkException {
    public ExistentLinkException(String link) {
        super("El link " + link + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
