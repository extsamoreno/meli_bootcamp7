package com.example.MeliSocialApi.project.exception;

import org.springframework.http.HttpStatus;

public class ProductNoPromoException extends ProductException{
    public ProductNoPromoException() {
        super("The prod is not a promo", HttpStatus.BAD_REQUEST);
    }
}
