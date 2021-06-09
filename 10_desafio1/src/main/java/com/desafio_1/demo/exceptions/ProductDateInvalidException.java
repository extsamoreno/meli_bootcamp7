package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDateInvalidException extends ResponseException{
    public ProductDateInvalidException() {
        super("La fecha del producto es invalida", HttpStatus.BAD_REQUEST);
    }
}
