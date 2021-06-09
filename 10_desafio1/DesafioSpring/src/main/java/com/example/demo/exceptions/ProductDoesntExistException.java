package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDoesntExistException extends ResponseException{
    public ProductDoesntExistException(int product_id) {
        super("El producto con id "+ product_id +" no existe", HttpStatus.BAD_REQUEST);
    }
}
