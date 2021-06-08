package com.example.linktracker.exception;

import org.springframework.http.HttpStatus;

public class LinkUnavailableException extends LinkException {

    public LinkUnavailableException(Integer linkID) {
        super("URL ID: " + linkID + " is disabled", HttpStatus.NOT_ACCEPTABLE);
    }
}
