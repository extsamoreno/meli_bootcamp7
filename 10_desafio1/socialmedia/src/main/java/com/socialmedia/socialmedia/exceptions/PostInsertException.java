package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class PostInsertException extends SocialMediaException {
    public PostInsertException() {
        super("Error al agregar post.", HttpStatus.BAD_REQUEST);
    }
}
