package com.spring4.ejercicios.link.exception;

import org.springframework.http.HttpStatus;

public class InvalidLinkException extends LinkException {

    public InvalidLinkException(String url) {
        super("The URL: " +url+ " is Invalid.", HttpStatus.NOT_FOUND);
    }
}
