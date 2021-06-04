package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

import java.net.URI;

public class InvalidURLException extends LinkException {
    public InvalidURLException(String url) {
        super("La URL: " + url + " no es valida", HttpStatus.BAD_REQUEST);
    }
}
