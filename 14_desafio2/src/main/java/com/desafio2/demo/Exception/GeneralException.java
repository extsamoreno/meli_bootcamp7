package com.desafio2.demo.Exception;

import com.desafio2.demo.Model.DTO.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GeneralException extends Exception {
    private ErrorDTO error = new ErrorDTO();
    private HttpStatus status;

    public GeneralException(String message, HttpStatus status) {
        this.error.setMessage(message);
        this.error.setName(getClass().getSimpleName());
        this.status = status;
    }
}