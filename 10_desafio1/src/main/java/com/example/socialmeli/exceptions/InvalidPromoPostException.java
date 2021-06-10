package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPromoPostException extends PostException{
    public InvalidPromoPostException() {
        super("La publicación que desea realizar no es de una en promoción. Verifique el parametro hasPromo.", HttpStatus.BAD_REQUEST);
    }
}
