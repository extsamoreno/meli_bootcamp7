package com.linktraker.linktraker.exceptions;

import org.springframework.http.HttpStatus;

public class DisableException extends LinkTrackerException {

    public DisableException() {
        super("El sitio se encuentra deshabilitado.", HttpStatus.BAD_REQUEST);
    }
}
