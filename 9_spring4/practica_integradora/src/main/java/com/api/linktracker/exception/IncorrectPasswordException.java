package com.api.linktracker.exception;

import com.api.linktracker.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IncorrectPasswordException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;
    private String name;

    public IncorrectPasswordException(){
        this.errorDTO = new ErrorDTO("ERROR: Incorrect Password", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.FORBIDDEN;
    }
}
