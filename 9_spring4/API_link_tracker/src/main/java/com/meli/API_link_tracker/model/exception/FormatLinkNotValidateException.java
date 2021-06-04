package com.meli.API_link_tracker.model.exception;

import org.springframework.http.HttpStatus;

public class FormatLinkNotValidateException extends LinkTrackerException{
    public FormatLinkNotValidateException() {
        super("Invalid link format", HttpStatus.BAD_REQUEST);
    }
}
