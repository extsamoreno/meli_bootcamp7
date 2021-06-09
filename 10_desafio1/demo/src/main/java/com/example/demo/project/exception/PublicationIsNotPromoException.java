package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class PublicationIsNotPromoException extends PublicationException {
    public PublicationIsNotPromoException() {
        super("La publicacion que intenta ingresar no es Promo", HttpStatus.BAD_REQUEST);
    }
}
