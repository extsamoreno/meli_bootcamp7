package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionAlreadyExists extends LinkException {
    public LinkExceptionAlreadyExists(String url) {
        super("A link with url: ".concat(url).concat(" already exists"),
                HttpStatus.BAD_REQUEST);
    }
}
