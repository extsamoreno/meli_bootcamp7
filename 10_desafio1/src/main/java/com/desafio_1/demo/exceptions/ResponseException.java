package com.desafio_1.demo.exceptions;

import com.desafio_1.demo.dtos.ErrorDTO;
import lombok.*;
import org.springframework.http.HttpStatus;

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
