package com.example.LinkTracker.exceptions;

import org.springframework.http.HttpStatus;

public class UnexistentLinkException extends LinkException{
    public UnexistentLinkException(int idLink) {
        super("El link con id " + idLink + " no existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
