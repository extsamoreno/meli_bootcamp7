package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailIdInvalidException extends ResponseException{
    public ProductDetailIdInvalidException() {
        super("El id del producto es invalido.", HttpStatus.BAD_REQUEST);
    }
}
