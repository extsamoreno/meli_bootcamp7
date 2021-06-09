package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class ErrorOrderParamDateException extends SocialMeliException{
    public ErrorOrderParamDateException() {
        super("Order parameter value error, supported parameters 'date_asc' or 'date_desc'", HttpStatus.BAD_REQUEST);
    }
}
