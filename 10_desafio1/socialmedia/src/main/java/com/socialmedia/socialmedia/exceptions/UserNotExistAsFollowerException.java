package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotExistAsFollowerException extends SocialMediaException {
    public UserNotExistAsFollowerException(int userId, int userIdToFollow) {
        super("El vendedor " + userIdToFollow + " no es seguido por el usuario " + userId, HttpStatus.BAD_REQUEST);
    }
}
