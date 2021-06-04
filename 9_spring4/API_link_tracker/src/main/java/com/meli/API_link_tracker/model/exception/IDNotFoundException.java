package com.meli.API_link_tracker.model.exception;

import org.springframework.http.HttpStatus;

public class IDNotFoundException extends LinkTrackerException{
    public IDNotFoundException(int linkId) {
        super("The id '" + linkId + "' does not correspond to any saved link", HttpStatus.NOT_FOUND);
    }
}