package com.example.project_url.exception;

import org.springframework.http.HttpStatus;

public class LinkExceptionEmptyUrl extends LinkException{
    public LinkExceptionEmptyUrl() {
        super("The url can't be empty", HttpStatus.BAD_REQUEST);
    }
}
