package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidIdException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public InvalidIdException(){
        this.errorDTO = new ErrorDTO("ERROR: The entered UserId does not match with any registered User", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
