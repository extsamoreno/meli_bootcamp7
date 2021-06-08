package com.desafio.SocialMeli.Exception.Product;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class ProductIdNotFoundException extends SocialMeliException {
    public ProductIdNotFoundException(Integer productID) {
        super("ID "+productID+" does not belong to any product", HttpStatus.BAD_REQUEST);
    }
}
