package com.linktraker.linktraker.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotExistException extends LinkTrackerException {

    public LinkNotExistException(String url) {
        super("La url " + url + " no existe.", HttpStatus.BAD_REQUEST);
    }
}
