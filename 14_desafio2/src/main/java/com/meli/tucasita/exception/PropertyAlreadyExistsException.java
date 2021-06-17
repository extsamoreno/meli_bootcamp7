package com.meli.tucasita.exception;

import com.meli.tucasita.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyAlreadyExistsException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public PropertyAlreadyExistsException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered Property already exists in database", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
