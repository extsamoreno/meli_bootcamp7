package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class DuplicatedPublicationIdException extends PublicationException {
    public DuplicatedPublicationIdException(Integer id) {
        super("La publicacion de id: "+id+" ya existe", HttpStatus.BAD_REQUEST);
    }
}
