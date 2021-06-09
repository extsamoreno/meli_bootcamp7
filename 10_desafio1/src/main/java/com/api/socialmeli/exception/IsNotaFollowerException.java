package com.api.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class IsNotaFollowerException extends SocialMeliException{
    public IsNotaFollowerException(int id, int id2) {
        super("id: " + id + " is not a follower of id: " + id2, HttpStatus.BAD_REQUEST);
    }
}
