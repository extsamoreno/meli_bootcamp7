package com.desafio.SocialMeli.Exception.Product;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class ProductExistsException extends SocialMeliException {
    public ProductExistsException(int product_id) {
        super("Product ID " + product_id + " already exists", HttpStatus.BAD_REQUEST);
    }
}
