package com.meli.demo.exceptions;

import org.springframework.http.HttpStatus;

public class FollowException extends SocialExcepton{
    public FollowException() {
        super("no existe o el usuario o el vendedor", HttpStatus.BAD_REQUEST);
    }
}