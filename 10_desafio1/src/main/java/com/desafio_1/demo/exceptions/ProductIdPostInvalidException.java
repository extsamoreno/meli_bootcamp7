package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductIdPostInvalidException extends ResponseException{
    public ProductIdPostInvalidException() {
        super("El id del post es invalido.", HttpStatus.BAD_REQUEST);
    }
}
