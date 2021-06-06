package com.linktracker.api.exception;

import org.springframework.http.HttpStatus;

public class LinkTrackerNoValidException extends LinkTrackerException{
    public LinkTrackerNoValidException() {
        super("No valid Link", HttpStatus.BAD_REQUEST);
    }
}
