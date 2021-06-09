package com.example.DesafioSpring.exceptions;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends PostException {
    public PostNotFoundException(int productId) {
        super(productId+" not found", HttpStatus.BAD_REQUEST);
    }
}
