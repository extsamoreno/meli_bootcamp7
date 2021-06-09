package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class ProductExceptionNotValid extends ProductException{

    public ProductExceptionNotValid(String message) {
        super("Product not valid, ".concat(message), HttpStatus.BAD_REQUEST);
    }
}
