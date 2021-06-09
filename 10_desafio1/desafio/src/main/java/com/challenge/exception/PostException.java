package com.challenge.exception;

import com.challenge.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class PostException extends Exception {

    private ErrorResponse error;
    private HttpStatus status;

    public PostException(String message, HttpStatus status) {
        this.error = new ErrorResponse(message, this.getClass().getSimpleName());
        this.status = status;
    }

    public ErrorResponse getError() {
        return error;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
