package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public abstract class ProductException extends WebException{
    public ProductException(String message, HttpStatus status) {
        super(message, status);
    }
}
