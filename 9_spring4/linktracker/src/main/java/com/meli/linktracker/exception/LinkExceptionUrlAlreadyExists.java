package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LinkExceptionUrlAlreadyExists extends LinkException {

    public LinkExceptionUrlAlreadyExists(String url) {
        super("URL : " + url + "is not active ", BAD_REQUEST);
    }
}
