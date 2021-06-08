package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class SocialExceptionMissingParameter extends SocialException{

    public SocialExceptionMissingParameter(String parameterName) {
        super("Missing parameter " + parameterName, HttpStatus.BAD_REQUEST);
    }
}
