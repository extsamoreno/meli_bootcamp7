package com.meli.desafio.exceptions.models;

import com.meli.desafio.exceptions.models.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionModel extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public ExceptionModel(String message, HttpStatus status){
        this.error = ErrorDTO.builder()
                .message(message)
                .name(this.getClass().getSimpleName())
                .build();

        this.status = status;
    }
}
