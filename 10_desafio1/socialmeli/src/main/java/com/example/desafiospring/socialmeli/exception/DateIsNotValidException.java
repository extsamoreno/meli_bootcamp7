package com.example.desafiospring.socialmeli.exception;

import org.springframework.http.HttpStatus;

/**
 * exception the date
 */
public class DateIsNotValidException extends SocialMeliException {
    public DateIsNotValidException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
