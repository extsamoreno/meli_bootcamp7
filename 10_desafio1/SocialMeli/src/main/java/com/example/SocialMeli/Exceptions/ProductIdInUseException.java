package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends UserException{
    public ProductNotFoundException(int UserId) {
        super("Product: "+UserId+" not found", HttpStatus.BAD_REQUEST);
    }
}
