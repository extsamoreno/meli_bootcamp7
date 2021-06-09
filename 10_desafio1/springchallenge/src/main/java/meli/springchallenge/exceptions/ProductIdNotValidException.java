package meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class ProductIdNotValidException extends SocialMeliException{

    public ProductIdNotValidException(int productId) {
        super("Product #" + productId + " is NOT valid ", HttpStatus.BAD_REQUEST);
    }
}
