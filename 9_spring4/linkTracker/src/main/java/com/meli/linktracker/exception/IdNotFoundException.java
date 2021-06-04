package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends LinkException {

    public IdNotFoundException(Integer linkId) {
        super("El Link ID: " + linkId + " no es valida", HttpStatus.NOT_FOUND);
    }
}
