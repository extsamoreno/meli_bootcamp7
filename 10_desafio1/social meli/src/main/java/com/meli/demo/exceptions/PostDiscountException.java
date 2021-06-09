package com.meli.demo.exceptions;

import org.springframework.http.HttpStatus;

public class PostDiscountException  extends SocialExcepton{
    public PostDiscountException() {
        super("el vendedor no fue encontrado", HttpStatus.BAD_REQUEST);
    }
}
