package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductIdInUseException extends UserException{
    public ProductIdInUseException(int productId) {
        super("Product: "+productId+" is already being used", HttpStatus.BAD_REQUEST);
    }
}
