package com.meli.spring_challenge.exception;

import org.springframework.http.HttpStatus;

public class UserRelationNotFoundException extends UserException{
    public UserRelationNotFoundException(int userID, int userIdToFollow){
        super("User relation with userID: " + userID + " and userIdToFollow: "+ userIdToFollow +  " Not exist!", HttpStatus.BAD_REQUEST);
    }

}
