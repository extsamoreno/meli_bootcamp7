package com.spring4.spring4.Exceptions;

import org.springframework.http.HttpStatus;

public class LinkInactiveException extends ObjectException{
    public LinkInactiveException(Integer id) {
        super("Link " + id.toString() + " inactivo.", HttpStatus.CONFLICT);
    }
}
