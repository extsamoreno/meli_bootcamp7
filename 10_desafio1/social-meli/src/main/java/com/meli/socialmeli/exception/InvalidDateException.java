package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class InvalidDateException extends ApiException {
    public InvalidDateException() {
        super("The post date can not be after today's date", HttpStatus.BAD_REQUEST);
    }
}
