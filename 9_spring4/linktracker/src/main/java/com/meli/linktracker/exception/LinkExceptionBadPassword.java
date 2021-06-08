package com.meli.linktracker.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class LinkExceptionBadPassword extends LinkException {

    public LinkExceptionBadPassword(String url) {
        super("the password is not correct from url : " + url,
                HttpStatus.UNAUTHORIZED);
    }
}
