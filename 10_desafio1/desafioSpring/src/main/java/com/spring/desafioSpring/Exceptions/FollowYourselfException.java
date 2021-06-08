package com.spring.desafioSpring.Exceptions;

import org.springframework.http.HttpStatus;

public class FollowYourselfException extends ObjectException{
    public FollowYourselfException() {
        super("Un usuario no puede seguirse a si mismo", HttpStatus.BAD_REQUEST);
    }
}
