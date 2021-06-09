package com.desafiospring.socialMeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowsException extends UserException {
    public UserAlreadyFollowsException(int userId, int userIdToFollow) {
        super("User with ID:" + userId + " already follows User with ID: "
                + userIdToFollow, HttpStatus.BAD_REQUEST);
    }
}
