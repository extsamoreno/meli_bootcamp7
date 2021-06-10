package com.meli.desafio.users.exceptions;

import com.meli.desafio.exceptions.models.ExceptionModel;
import org.springframework.http.HttpStatus;

public class UserNotFollowed extends ExceptionModel {
    public UserNotFollowed(Integer id) {
        super("you dont follow the with id: " + id, HttpStatus.BAD_REQUEST);
    }
}
