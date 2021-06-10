package com.desafio1.meli.exceptions;

import org.springframework.http.HttpStatus;

public class NotExistUser extends MainException {

    public NotExistUser(Integer userId) {
        super("User ID: " + userId + " not exist", HttpStatus.BAD_REQUEST);
    }
}