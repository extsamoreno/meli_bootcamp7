package com.desafiotesting.api.exception;

import org.springframework.http.HttpStatus;

public class NotFoundDistrictException extends TasacionesException {
    public NotFoundDistrictException() {
        super("District not found!", HttpStatus.BAD_REQUEST);
    }
}

