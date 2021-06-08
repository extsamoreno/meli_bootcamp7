package com.example.demo.Exceptions;

import com.example.demo.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;


public class UrlException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UrlException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
