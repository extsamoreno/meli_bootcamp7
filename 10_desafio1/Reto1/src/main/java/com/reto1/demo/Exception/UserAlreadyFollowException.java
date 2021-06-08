package com.reto1.demo.Exception;

import com.reto1.demo.Model.User;
import org.springframework.http.HttpStatus;

public class UserAlreadyFollowException extends UserException {
    public UserAlreadyFollowException(String name) {
        super("User "+name+" already was follow", HttpStatus.CONFLICT);
    }
}
