package com.challenge.exception;

import com.challenge.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class UserException extends Exception {

    private ErrorResponse error;
    private HttpStatus httpStatus;

    public UserException(String message, HttpStatus status) {
        this.error = new ErrorResponse(message, this.getClass().getSimpleName());
        this.httpStatus = status;
    }

    public ErrorResponse getError() {
        return error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
