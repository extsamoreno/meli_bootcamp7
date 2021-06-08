package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;

public class LinkPasswordNotCorrect extends LinkException {

    public LinkPasswordNotCorrect() {
        super("The password is not correct", HttpStatus.BAD_REQUEST);
    }
}
