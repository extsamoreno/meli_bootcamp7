package com.meli.socialmeli.model.exception;

import org.springframework.http.HttpStatus;

public class SellerCanNotFollowException extends SocialMeliException{
    public SellerCanNotFollowException(int userId) {
        super("The user with id '" + userId +"' is Seller, the sellers can't follow to other Users",
                HttpStatus.BAD_REQUEST);
    }
}
