package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionInactive extends LinkException{
    public LinkExceptionInactive(int linkId) {
        super("Link with id: ".concat(Integer.toString(linkId).concat(" is inactive")), HttpStatus.BAD_REQUEST);
    }
}
