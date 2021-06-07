package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkDeactivetedException extends LinkException{

    public LinkDeactivetedException(int id) {

        super("The URL id#" + id + "is not longer active, or is not loaded", HttpStatus.BAD_REQUEST);
    }
}
