package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class InvalidDateFormatException extends SocialMeliException {

    public InvalidDateFormatException(String date) {
        super("Date:" + date + " is not a valid date format, must be like dd-MM-yyyy", HttpStatus.BAD_REQUEST);
    }
}
