package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LinkExceptionURLInactive extends  LinkException{

    public LinkExceptionURLInactive(int linkId) {
        super("Link id: " + linkId + "is not active ", BAD_REQUEST);
    }
}
