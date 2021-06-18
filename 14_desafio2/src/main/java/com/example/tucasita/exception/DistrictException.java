package com.example.tucasita.exception;

import com.example.tucasita.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class DistrictException extends RuntimeException{
    private final ErrorDTO error;
    private final HttpStatus status;

    public DistrictException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
