package com.example.desafio1.exceptions.user;

import org.springframework.http.HttpStatus;

public class SelfFollowUnFollowException extends UserException {
    public SelfFollowUnFollowException() {
        super("No te puedes seguir o dejar de seguir a ti mismo!", HttpStatus.BAD_REQUEST);
    }
}
