package com.meli.desafio.users.exceptions;

import com.meli.desafio.exceptions.models.ExceptionModel;
import org.springframework.http.HttpStatus;

public class UserFollowYourselfException extends ExceptionModel {
    public UserFollowYourselfException() {
        super("you cant follow yourself", HttpStatus.BAD_REQUEST);
    }
}
