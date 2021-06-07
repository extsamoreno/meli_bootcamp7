package com.api.apiMask.exception;

import com.api.apiMask.controller.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class LinkException extends Exception{
    private final ErrorDTO error;
    HttpStatus status;

    public LinkException(String message, HttpStatus status){
        this.error = new ErrorDTO(message);
        this.status = status;
    }

}
