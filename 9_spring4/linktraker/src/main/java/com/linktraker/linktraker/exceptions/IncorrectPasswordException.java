package com.linktraker.linktraker.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends LinkTrackerException {

    public IncorrectPasswordException() {
        super("La contraseña es incorrecta.", HttpStatus.BAD_REQUEST);
    }
}
