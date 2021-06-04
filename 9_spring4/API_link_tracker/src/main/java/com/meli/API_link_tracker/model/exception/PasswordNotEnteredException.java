package com.meli.API_link_tracker.model.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotEnteredException extends LinkTrackerException{
    public PasswordNotEnteredException() {
        super("Request made without password in query param.", HttpStatus.BAD_REQUEST);
    }
}