package com.linktracker.api.exception;

import org.springframework.http.HttpStatus;

public class LinkTrackerBadPasswordException extends LinkTrackerException{

    public LinkTrackerBadPasswordException() {
        super("Incorrect password", HttpStatus.BAD_REQUEST);
    }
}
