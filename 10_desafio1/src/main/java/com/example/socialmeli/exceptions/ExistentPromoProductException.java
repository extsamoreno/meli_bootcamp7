package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentPromoProductException extends ProductException{
    public ExistentPromoProductException(String promoProductId) {
        super("El producto en promocion con ID " + promoProductId + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
