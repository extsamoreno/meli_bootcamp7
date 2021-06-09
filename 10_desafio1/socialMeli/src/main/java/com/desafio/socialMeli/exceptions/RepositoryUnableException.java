package com.desafio.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class RepositoryUnableException extends UserException {
    public RepositoryUnableException() {
        super("Repositorio de usuarios no disponible ", HttpStatus.BAD_REQUEST);
    }
}