package com.testingchallenge.tucasita.exception;

import com.testingchallenge.tucasita.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public PropertyException (String message, HttpStatus status) {
        error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
