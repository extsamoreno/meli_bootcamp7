package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailColorRequiredException extends ResponseException{
    public ProductDetailColorRequiredException() {
        super("El color es requerido", HttpStatus.BAD_REQUEST);
    }
}
