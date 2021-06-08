package com.springChallenge.api.controller.exception.user;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@Getter
public class AlreadyFollowedException extends UserValidationsException {
    public AlreadyFollowedException(int userToFollow, int follower){
        super(MessageFormat.format("The user ''{0}'' is already followed by ''{1}''", userToFollow, follower), HttpStatus.BAD_REQUEST);
    }
}
