package com.desafio.SocialMeli.Exception.Product;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class ProductNotExistsException extends SocialMeliException {
    public ProductNotExistsException(int product_id) {
        super("Product with ID " + product_id + " does not exists. Check product parameters", HttpStatus.BAD_REQUEST);
    }
}
