package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserIsNotMerchant extends UserException{
    public UserIsNotMerchant(int userId) {
        super("El usiario " +userId+ " no es un vendedor.", HttpStatus.BAD_REQUEST);
    }
}
