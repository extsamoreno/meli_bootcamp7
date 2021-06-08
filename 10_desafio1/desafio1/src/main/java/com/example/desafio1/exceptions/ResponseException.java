package com.example.desafio1.exceptions;

import com.example.desafio1.dtos.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public ResponseException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
