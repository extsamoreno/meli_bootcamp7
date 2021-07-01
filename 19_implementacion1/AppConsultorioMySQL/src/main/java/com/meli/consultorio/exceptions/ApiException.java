package com.meli.consultorio.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final ApiError error;
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        this.error = new ApiError(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}