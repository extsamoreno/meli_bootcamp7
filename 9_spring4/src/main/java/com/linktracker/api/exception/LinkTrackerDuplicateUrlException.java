package com.linktracker.api.exception;

import org.springframework.http.HttpStatus;

public class LinkTrackerDuplicateUrlException extends LinkTrackerException {
    public LinkTrackerDuplicateUrlException() {
        super("Duplicate URL", HttpStatus.BAD_REQUEST);
    }
}
