package com.meli.tucasita.exception;

import com.meli.tucasita.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidDistrictException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public InvalidDistrictException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered district name does not match with any valid District", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
