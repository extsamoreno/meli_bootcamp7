package com.example.Challenge.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends ProgramException{
    public ProductException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}