package com.meli.spring_challenge.exception.user;

import org.springframework.http.HttpStatus;

public class UserNotSellerException extends UserException{
    public UserNotSellerException(int userID){
        super("The userID is Not Seller", HttpStatus.BAD_REQUEST);
    }
}
