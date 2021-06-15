package com.springbootday2.springbootday2.exceptions;

import com.springbootday2.springbootday2.dtos.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StudentException extends Exception {
    private ErrorDTO error;
    private HttpStatus status;

    public StudentException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
