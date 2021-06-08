package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductIdInUseException extends ProductException{
    public ProductIdInUseException(int productId) {
        super("Product ID: "+productId+" is already being used", HttpStatus.BAD_REQUEST);
    }
}
