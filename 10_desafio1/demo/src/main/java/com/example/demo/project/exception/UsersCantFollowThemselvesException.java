package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class UsersCantFollowThemselvesException extends UserException {
    public UsersCantFollowThemselvesException() {
        super("El usuario no puede seguirse a si mismo", HttpStatus.BAD_REQUEST);
    }
}
