package com.bootcamp.desafio1.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends GeneralException {
    public ProductNotFoundException(int productId) {
        super("The Product ID: " +productId+ " is not found in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
