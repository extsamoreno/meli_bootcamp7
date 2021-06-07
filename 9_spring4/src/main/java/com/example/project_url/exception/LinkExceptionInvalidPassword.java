package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionInvalidPassword extends LinkException {
    public LinkExceptionInvalidPassword() {
        super("Invalid password for link", HttpStatus.BAD_REQUEST);
    }
}
