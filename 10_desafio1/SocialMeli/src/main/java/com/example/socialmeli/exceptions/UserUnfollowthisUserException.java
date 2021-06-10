package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserUnfollowthisUserException extends UserException {
    public UserUnfollowthisUserException(int idUser) {
        super("the user id " + idUser + " cannot be the same as the user to unfollow", HttpStatus.BAD_REQUEST);
    }
}
