package com.example.demo.socialmeli.exception;

import com.example.demo.socialmeli.service.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MissingParameterException extends Exception{

    private ErrorDTO errorDTO;
    private HttpStatus httpStatus;

    public MissingParameterException (String parameter) {
        this.errorDTO = new ErrorDTO();
        this.errorDTO.setMessage("No se ingresó información sobre " + parameter);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
}
