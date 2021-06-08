package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class UserExistAsFollowerException extends SocialMediaException {
    public UserExistAsFollowerException(int userId, int userIdToFollow) {
        super("El comprador " + userIdToFollow + " ya es seguido por el usuario " + userId, HttpStatus.BAD_REQUEST);
    }
}
