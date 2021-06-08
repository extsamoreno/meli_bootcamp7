package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class InvaidLinkException extends LinkException {
    public InvaidLinkException(int id) {
        super("Status id "+id+" is invalidated", HttpStatus.METHOD_NOT_ALLOWED);
    }
}
