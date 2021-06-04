package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends LinkException {

    public IdNotFoundException(Integer linkId) {
        super("Link ID: " + linkId + " invalid or does not exist", HttpStatus.NOT_FOUND);
    }
}
