package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailTypeRequiredException extends ResponseException{
    public ProductDetailTypeRequiredException() {
        super("El tipo de producto es requerido", HttpStatus.BAD_REQUEST);
    }
}
