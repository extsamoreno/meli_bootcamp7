package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ProductException{
    public ProductNotFoundException(int productId) {
        super("Product: "+productId+" not found", HttpStatus.NOT_FOUND);
    }
}
