package com.reto1.demo.Exception;

import org.springframework.http.HttpStatus;

public class DuplicatedPostException extends GeneralException {
    public DuplicatedPostException(int id_post) {
        super("The post "+id_post+" already exist.", HttpStatus.CONFLICT);
    }
}
