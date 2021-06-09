package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class ErrorOrderParamNameException extends SocialMeliException{
    public ErrorOrderParamNameException() {
        super("Order parameter value error, supported parameters 'name_asc' or 'name_desc'", HttpStatus.BAD_REQUEST);
    }
}
