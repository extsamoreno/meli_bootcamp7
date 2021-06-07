package com.meli.spring.exceptions;

import org.springframework.http.HttpStatus;

public class LinkUnauthorizedException extends LinkException{
    public LinkUnauthorizedException() {
        super("El linkID o Password es Incorrecta!", HttpStatus.UNAUTHORIZED);
    }
}
