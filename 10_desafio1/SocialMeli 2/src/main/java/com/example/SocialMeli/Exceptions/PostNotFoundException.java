package com.example.SocialMeli.Exceptions;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends PostException{
    public PostNotFoundException(int productId) {
        super("Product: "+productId+" not found", HttpStatus.BAD_REQUEST);
    }
}
