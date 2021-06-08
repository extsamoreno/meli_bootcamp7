package com.api.linktracker.exception;

import com.api.linktracker.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidatedLinkException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;
    private String name;

    public InvalidatedLinkException(){
        this.errorDTO = new ErrorDTO("ERROR: This link has been invalidated", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.CONFLICT;
    }
}
