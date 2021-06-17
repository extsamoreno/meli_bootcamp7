package com.desafio.TuCasitaTasacionesApp.model.exceptions;

import com.desafio.TuCasitaTasacionesApp.model.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropietyException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public PropietyException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}
