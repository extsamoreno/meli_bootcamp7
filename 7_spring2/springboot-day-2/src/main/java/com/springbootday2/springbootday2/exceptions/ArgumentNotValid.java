package com.springbootday2.springbootday2.exceptions;

import org.springframework.http.HttpStatus;

public class ArgumentNotValid extends StudentException {
    public ArgumentNotValid(String message, HttpStatus status) {
        super(message, status);
    }
}
