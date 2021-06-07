package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionInvalidUrl extends LinkException {
    public LinkExceptionInvalidUrl() {
        super("Invalid link", HttpStatus.BAD_REQUEST);
    }
}
