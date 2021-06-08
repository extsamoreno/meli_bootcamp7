package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class DuplicatedLinkException extends LinkException {
    public DuplicatedLinkException(String link) {
        super("Link "+link+" already exist." , HttpStatus.CONFLICT);
    }
}
