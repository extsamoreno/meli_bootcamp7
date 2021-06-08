package com.meli.linktracker.exception;

import com.meli.linktracker.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

    public LinkException(String message, HttpStatus status) {
        this.error = new ErrorDTO(message, this.getClass().getSimpleName());
        this.status = status;
    }
}
