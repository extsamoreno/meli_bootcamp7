package com.spring.desafioSpring.Exceptions;

import org.springframework.http.HttpStatus;

public class PostIdExistsException extends ObjectException{
    public PostIdExistsException(int id) {
        super("Ya existe un post con el id: " + id, HttpStatus.BAD_REQUEST);
    }
}
