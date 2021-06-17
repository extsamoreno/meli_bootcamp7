package com.bootcamp.tucasitatasaciones.exception;

import com.bootcamp.tucasitatasaciones.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends Exception{

    private ErrorDTO error;
    private HttpStatus httpStatus;

    public PropertyException(String description, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setDescription(description);
        this.error.setName(this.getClass().getSimpleName());

        this.httpStatus = status;
    }
}
