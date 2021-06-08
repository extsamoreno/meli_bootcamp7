package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;

public class LinkIdNotFoundException extends LinkException {

    public LinkIdNotFoundException(Integer id) {
        super("ID " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
