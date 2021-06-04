package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

public class InvalidURLException extends LinkException {
    public InvalidURLException(String url) {
        super("URL: " + url + " is not valid", HttpStatus.BAD_REQUEST);
    }
}
