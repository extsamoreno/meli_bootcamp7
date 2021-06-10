package com.meli.demo.exceptions;

import org.springframework.http.HttpStatus;

public class FollowException extends SocialExcepton{
    public FollowException() {
        super("Por favor verifique si el usuario o el vendedor exisite de ser asi el usuario ya esta suscrito", HttpStatus.BAD_REQUEST);
    }
}