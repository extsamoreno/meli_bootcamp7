package com.meli.linktracker.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LinkExceptionBadURL extends LinkException{

    public LinkExceptionBadURL() {
        super("the URl is not correct ",
                BAD_REQUEST);
    }
}
