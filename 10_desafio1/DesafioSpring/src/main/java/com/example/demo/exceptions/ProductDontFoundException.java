package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDontFoundException extends ResponseException{
    public ProductDontFoundException(int product_id) {
        super("El producto con id "+ product_id +" no existe", HttpStatus.BAD_REQUEST);
    }
}
