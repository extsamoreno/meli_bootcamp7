package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailRequiredException extends ResponseException{
    public ProductDetailRequiredException() {
        super("El detalle del producto es requerido", HttpStatus.BAD_REQUEST);
    }
}
