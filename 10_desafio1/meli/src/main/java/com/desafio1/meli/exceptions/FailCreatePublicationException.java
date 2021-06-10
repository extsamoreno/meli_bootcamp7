package com.desafio1.meli.exceptions;
import org.springframework.http.HttpStatus;

public class FailCreatePublicationException extends MainException{
    public FailCreatePublicationException(Integer postId) {
        super("Already Existing Publication ID:" + postId, HttpStatus.BAD_REQUEST);
    }
}
