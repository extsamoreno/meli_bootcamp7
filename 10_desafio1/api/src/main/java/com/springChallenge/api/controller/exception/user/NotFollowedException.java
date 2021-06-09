package com.springChallenge.api.controller.exception.user;

import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

public class NotFollowedException extends UserValidationsException {
    public NotFollowedException(int userToUnfollow, int follower) {
        super(MessageFormat.format("The user ''{0}'' is not being followed by ''{1}''", userToUnfollow, follower), HttpStatus.BAD_REQUEST);
    }
}