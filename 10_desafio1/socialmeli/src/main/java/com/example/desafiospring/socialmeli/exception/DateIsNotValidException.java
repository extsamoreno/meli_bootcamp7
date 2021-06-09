package com.example.desafiospring.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class DateIsNotValidException extends CustomException{
    public DateIsNotValidException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
