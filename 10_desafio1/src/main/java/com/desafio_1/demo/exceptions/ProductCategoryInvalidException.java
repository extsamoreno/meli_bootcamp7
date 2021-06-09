package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductCategoryInvalidException extends ResponseException{
    public ProductCategoryInvalidException() {
        super("El id de categoria es requerido", HttpStatus.BAD_REQUEST);
    }
}
