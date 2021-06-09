package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailNameRequiredException extends ResponseException{
    public ProductDetailNameRequiredException() {
        super("El nombre del producto es requerido.", HttpStatus.BAD_REQUEST);
    }
}
