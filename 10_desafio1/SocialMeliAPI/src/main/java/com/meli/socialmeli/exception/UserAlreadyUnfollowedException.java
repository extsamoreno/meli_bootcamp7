package com.meli.socialmeli.exception;

import com.meli.socialmeli.model.User;
import org.springframework.http.HttpStatus;

public class UserAlreadyUnfollowedException extends UserException{
    public UserAlreadyUnfollowedException(User user){
        super("The user with user id "+user.getUserId()+" is already unfollowed", HttpStatus.BAD_REQUEST);

    }
}
