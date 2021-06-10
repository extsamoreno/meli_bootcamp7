package com.desafiospring.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyUnfollowsException extends UserException {
    public UserAlreadyUnfollowsException(int userId, int userIdToFollow) {
        super("User with ID:" + userId + " already unfollows User with ID: "
                + userIdToFollow, HttpStatus.BAD_REQUEST);
    }

}
