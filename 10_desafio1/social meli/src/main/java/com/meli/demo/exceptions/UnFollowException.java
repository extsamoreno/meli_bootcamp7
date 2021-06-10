package com.meli.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UnFollowException extends SocialExcepton{
    public UnFollowException() {
        super("Por favor verifique si el usuario o el vendedor exisite de ser asi el usuario no esta suscrito", HttpStatus.BAD_REQUEST);
    }
}
