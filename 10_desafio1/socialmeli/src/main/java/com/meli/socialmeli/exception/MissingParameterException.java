package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class MissingParameterException extends SocialException{

    public MissingParameterException(String parameterName) {
        super("Missing parameter " + parameterName, HttpStatus.BAD_REQUEST);
    }
}
