package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductPriceInvalidException extends ResponseException{
    public ProductPriceInvalidException() {
        super("El precio es invalido.", HttpStatus.BAD_REQUEST);
    }
}
