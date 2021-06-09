package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class ProductInsertException extends SocialMediaException {
    public ProductInsertException() {
        super("Error al agregar el producto.", HttpStatus.BAD_REQUEST);
    }
}
