package com.desafiotesting.api.exception;

import com.desafiotesting.api.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TasacionesException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public TasacionesException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setErrorName(this.getClass().getSimpleName());
        this.status = status;
    }
}
