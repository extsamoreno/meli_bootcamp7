package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectExistException extends SocialMediaException {
    public ObjectExistException(int id, String entity) {
        super(entity + ": " + id + " ya se encuentra agregado.", HttpStatus.BAD_REQUEST);
    }
}
