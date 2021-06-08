package com.bootcamp.linktracker.exception;

import com.bootcamp.linktracker.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception {
    private ErrorDTO error;
    private HttpStatus httpStatus;

    public LinkException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.httpStatus = status;
    }
}
