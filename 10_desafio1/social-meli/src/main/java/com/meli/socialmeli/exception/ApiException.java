package com.meli.socialmeli.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends Exception {
    private ApiError error;
    private HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        this.error = new ApiError();
        this.error.setError(this.getClass().getSimpleName());
        this.error.setMessage(message);

        this.status = status;
    }
}
