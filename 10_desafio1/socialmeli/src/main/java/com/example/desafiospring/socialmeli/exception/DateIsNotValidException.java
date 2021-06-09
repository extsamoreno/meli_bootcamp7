package com.example.desafiospring.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class DateIsNotValidException extends CustomException{  //excepcion en la date, extiende
    public DateIsNotValidException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
