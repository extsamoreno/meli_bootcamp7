package com.desafio.socialMeli.model.exceptions;

import com.desafio.socialMeli.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;


public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public UserException(String message, HttpStatus status) {
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
