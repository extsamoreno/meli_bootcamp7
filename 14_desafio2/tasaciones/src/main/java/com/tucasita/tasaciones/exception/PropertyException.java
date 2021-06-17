package com.tucasita.tasaciones.exception;

import com.tucasita.tasaciones.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public class PropertyException extends Exception {

    private ErrorResponse error;
    private HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorResponse(message, this.getClass().getSimpleName());
        this.status = status;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
