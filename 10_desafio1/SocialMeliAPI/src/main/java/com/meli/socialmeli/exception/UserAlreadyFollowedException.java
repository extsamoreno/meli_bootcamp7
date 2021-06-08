package com.meli.socialmeli.exception;

import com.meli.socialmeli.model.User;
import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException{
    public UserAlreadyFollowedException(User user){
        super("The user with user id "+user.getUserId()+" is already followed", HttpStatus.BAD_REQUEST);

    }
}
