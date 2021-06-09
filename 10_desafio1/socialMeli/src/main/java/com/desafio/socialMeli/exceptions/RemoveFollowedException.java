package com.desafio.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class RemoveFollowedException extends UserException {
    public RemoveFollowedException(String userName) {
        super("No se pudo dejar de seguir al usuario " + userName , HttpStatus.BAD_REQUEST);
    }

}
