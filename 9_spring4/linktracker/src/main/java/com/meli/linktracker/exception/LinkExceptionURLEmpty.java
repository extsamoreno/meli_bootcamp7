package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LinkExceptionURLEmpty extends  LinkException{

    public LinkExceptionURLEmpty() {
        super("The URL is empty ", BAD_REQUEST);
    }
}
