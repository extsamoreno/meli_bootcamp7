package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentPromoPostException extends PostException{
    public ExistentPromoPostException(int promoPostId) {
        super("La publicaioón en promocion con ID " + promoPostId + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
