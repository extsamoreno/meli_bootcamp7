package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class FollowerNotRegisteredException extends UserException {

    public FollowerNotRegisteredException(int userId, int sellerId) {
        super("El usuario id: "+userId+" no sigue al vendedor id: " + sellerId, HttpStatus.BAD_REQUEST);
    }
}
