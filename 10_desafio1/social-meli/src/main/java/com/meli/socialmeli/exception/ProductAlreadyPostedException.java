package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyPostedException extends ApiException {
    public ProductAlreadyPostedException(Integer userId, Integer productId) {
        super("The product " + productId + " has already been posted in a publication by user " + userId, HttpStatus.BAD_REQUEST);
    }
}
