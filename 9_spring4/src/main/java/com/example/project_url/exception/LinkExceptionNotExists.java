package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionNotExists extends LinkException {

    public LinkExceptionNotExists(int urlId) {
        super("Link with id: ".concat(Integer.toString(urlId)).concat(" don't exists"), HttpStatus.BAD_REQUEST);
    }
}
