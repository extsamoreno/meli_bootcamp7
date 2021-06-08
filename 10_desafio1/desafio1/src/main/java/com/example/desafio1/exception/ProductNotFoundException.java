package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ProductException{
    public ProductNotFoundException(int productId)
    {
        super("The id: " + productId + ". Does not match to any existent product.\n" +
                "Try to create it in catalog first.", HttpStatus.BAD_REQUEST);
    }
}
