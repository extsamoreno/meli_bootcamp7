package com.desafio.socialMeli.model.exceptions;

import org.springframework.http.HttpStatus;

public class RemoveFollowerException extends UserException {
    public RemoveFollowerException(String userName) {
        super("No se pudo eliminar al seguidor " + userName, HttpStatus.BAD_REQUEST);
    }
}
