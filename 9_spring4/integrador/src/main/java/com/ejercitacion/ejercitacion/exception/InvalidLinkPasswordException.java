package com.ejercitacion.ejercitacion.exception;

import org.springframework.http.HttpStatus;

public class InvalidLinkPasswordException extends LinkException {

    public InvalidLinkPasswordException() {
        super("Incorrect password", HttpStatus.UNAUTHORIZED);
    }
}
