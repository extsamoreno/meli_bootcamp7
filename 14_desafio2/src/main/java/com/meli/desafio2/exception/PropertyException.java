package com.meli.desafio2.exception;

import com.meli.desafio2.model.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PropertyException extends Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public PropertyException(String s, HttpStatus notFound){
        this.error = new ErrorDTO(this.getClass().getSimpleName(), "Property not found");
        this.status = HttpStatus.NOT_FOUND;
    }
}
