package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NoFollowerException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public NoFollowerException(){
        this.errorDTO = new ErrorDTO("ERROR: This user does not follow the entered merchant", this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
