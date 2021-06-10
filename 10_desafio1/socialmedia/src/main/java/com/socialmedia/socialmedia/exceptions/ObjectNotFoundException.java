package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends SocialMediaException {
    public ObjectNotFoundException(int id) {
        super("El id " + id + " no se encuentra.", HttpStatus.BAD_REQUEST);
    }
}
