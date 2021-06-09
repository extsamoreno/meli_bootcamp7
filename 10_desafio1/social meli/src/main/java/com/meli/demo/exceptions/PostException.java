package com.meli.demo.exceptions;

import org.springframework.http.HttpStatus;

public class PostException extends SocialExcepton{
    public PostException() {
        super("el vendedor no fue encontrado", HttpStatus.BAD_REQUEST);
    }
}
