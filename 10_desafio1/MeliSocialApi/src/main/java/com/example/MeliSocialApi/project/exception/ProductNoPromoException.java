package com.example.MeliSocialApi.project.exception;

import org.springframework.http.HttpStatus;

public class ProductNoPromoException extends ProductException{
    public ProductNoPromoException() {
        super("The prod is not a Promo", HttpStatus.BAD_REQUEST);
    }
}
