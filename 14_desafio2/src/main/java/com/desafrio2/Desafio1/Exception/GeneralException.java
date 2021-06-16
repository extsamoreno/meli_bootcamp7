package com.desafrio2.Desafio1.Exception;

import com.desafrio2.Desafio1.Model.DTO.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GeneralException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public GeneralException(String message, HttpStatus status) {
        this.error.setMessage(message);
        this.error.setName(getClass().getSimpleName());
        this.status = status;
    }
}
