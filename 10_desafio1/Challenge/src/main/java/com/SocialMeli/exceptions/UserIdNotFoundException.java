package com.SocialMeli.exceptions;

import org.springframework.http.HttpStatus;
public class UserIdNotFoundException extends UserException {
    public UserIdNotFoundException(Integer id) {
        super("El usuario con el id " + id + " no fue encontrado.", HttpStatus.NOT_FOUND);
    }

}