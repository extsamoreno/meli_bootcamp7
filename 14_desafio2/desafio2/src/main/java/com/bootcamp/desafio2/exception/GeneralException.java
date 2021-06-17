package com.bootcamp.desafio2.exception;

import com.bootcamp.desafio2.dto.response.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public GeneralException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setName(this.getClass().getSimpleName());
        this.error.setMessage(message);
        this.status = status;
    }
}
