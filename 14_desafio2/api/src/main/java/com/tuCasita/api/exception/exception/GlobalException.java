package com.tuCasita.api.exception.exception;

import com.tuCasita.api.exception.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GlobalException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public GlobalException(String message, HttpStatus status){
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
