package com.ejercitacion.ejercitacion.exception;

import com.ejercitacion.ejercitacion.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class LinkException extends Exception {

    private ErrorResponse error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status) {
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
