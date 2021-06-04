package com.meli.API_link_tracker.model.exception;

import org.springframework.http.HttpStatus;

public class LinkAlreadyCreatedException extends LinkTrackerException{
    public LinkAlreadyCreatedException(String link) {
        super("The link `" + link + "`already created", HttpStatus.BAD_REQUEST);
    }
}