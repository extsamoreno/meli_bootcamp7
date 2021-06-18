package com.didney.junit.tucasitatasaciones.exception;

import com.didney.junit.tucasitatasaciones.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException {
    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
