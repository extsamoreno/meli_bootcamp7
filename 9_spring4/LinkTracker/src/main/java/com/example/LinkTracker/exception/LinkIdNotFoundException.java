package com.example.LinkTracker.exception;

import org.springframework.http.HttpStatus;

public class LinkIdNotFoundException extends LinkException {
    public LinkIdNotFoundException(Integer id) {
        super("El id: "+id+" no corresponde a ningun Link", HttpStatus.NOT_FOUND);
    }
}
