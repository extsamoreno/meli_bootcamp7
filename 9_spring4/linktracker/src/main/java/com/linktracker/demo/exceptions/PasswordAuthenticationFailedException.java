package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordAuthenticationFailedException extends ResponseException{
    public PasswordAuthenticationFailedException(){
        super("Password authentication failed!", HttpStatus.FORBIDDEN);
    }
}
