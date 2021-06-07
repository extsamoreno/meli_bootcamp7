package com.api.apiMask.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class LinkValidationException extends LinkException{
    public LinkValidationException(String message, HttpStatus status) {
        super(message, status);
    }
}
