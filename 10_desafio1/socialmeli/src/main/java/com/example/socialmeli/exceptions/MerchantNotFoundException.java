package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class MerchantNotFoundException extends SocialException {
    public MerchantNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
