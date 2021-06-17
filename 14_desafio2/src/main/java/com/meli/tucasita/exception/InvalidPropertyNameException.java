package com.meli.tucasita.exception;

import com.meli.tucasita.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidPropertyNameException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public InvalidPropertyNameException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered property name does not match with any registered Property", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
