package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class NotPromoPostException extends ApiException{
    public NotPromoPostException(int promoId) {
        super("You are trying to and a new Post with a promotion but the post " + promoId + " is with it disable.", HttpStatus.BAD_REQUEST);
    }

}
