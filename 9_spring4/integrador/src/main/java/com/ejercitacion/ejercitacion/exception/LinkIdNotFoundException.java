package com.ejercitacion.ejercitacion.exception;

import org.springframework.http.HttpStatus;

public class LinkIdNotFoundException extends LinkException {

    public LinkIdNotFoundException(Integer linkId) {
        super("The given ID " + linkId + " doesn't correspond to any stored link", HttpStatus.NOT_FOUND);
    }
}
