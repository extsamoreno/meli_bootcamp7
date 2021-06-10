package com.spring.desafioSpring.Exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyFollowException extends ObjectException{
    public AlreadyFollowException(int id) {
        super("Ya sigue al usuario: " + id, HttpStatus.CONFLICT);
    }
}
