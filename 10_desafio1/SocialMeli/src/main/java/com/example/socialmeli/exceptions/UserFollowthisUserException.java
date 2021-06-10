package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserFollowthisUserException extends UserException {
    public UserFollowthisUserException(int idUser) {
        super("the userid " + idUser + " cannot be the same as the user to follow", HttpStatus.BAD_REQUEST);
    }
}
