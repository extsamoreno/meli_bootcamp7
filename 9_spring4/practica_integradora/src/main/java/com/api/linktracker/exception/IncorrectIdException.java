package com.api.linktracker.exception;

import com.api.linktracker.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IncorrectIdException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;
    private String name;

    public IncorrectIdException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered Id does not match with any registered Id", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
