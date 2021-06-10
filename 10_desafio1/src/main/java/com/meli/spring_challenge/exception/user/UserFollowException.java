package com.meli.spring_challenge.exception.user;

import org.springframework.http.HttpStatus;

public class UserFollowException extends UserException{
    public UserFollowException(int userID, int userToFollowID){
        super("userID: " + userID + " can't follow to userToFollowID: " + userToFollowID, HttpStatus.BAD_REQUEST);
    }
}
