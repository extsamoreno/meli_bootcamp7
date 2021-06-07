package com.linktraker.linktraker.exceptions;

import org.springframework.http.HttpStatus;

public class LinkIdNotFoundException extends LinkTrackerException {

    public LinkIdNotFoundException(int idLink) {
        super("El id: " + idLink + " no se encuentra en la base de datos.", HttpStatus.BAD_REQUEST);
    }
}
