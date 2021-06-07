package com.example.LinkTracker.exception;

import org.springframework.http.HttpStatus;

public class LinkInvalidPassException extends LinkException {
    public LinkInvalidPassException(Integer id) {
        super("Incorrect pass", HttpStatus.METHOD_NOT_ALLOWED);
    }
}
