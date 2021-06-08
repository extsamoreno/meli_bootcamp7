package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends UserException{
    public ProductNotFoundException(int productId) {
        super("Product: "+productId+" not found", HttpStatus.BAD_REQUEST);
    }
}
