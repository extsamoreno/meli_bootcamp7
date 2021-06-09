package com.meli.desafio.users.exceptions;

import com.meli.desafio.exceptions.models.ExceptionModel;
import org.springframework.http.HttpStatus;

public class UserAlredyFollowedException extends ExceptionModel {
    public UserAlredyFollowedException() {
        super("you already follow this user", HttpStatus.BAD_REQUEST);
    }

}
