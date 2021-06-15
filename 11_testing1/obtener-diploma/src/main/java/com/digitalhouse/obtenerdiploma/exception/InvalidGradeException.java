package com.digitalhouse.obtenerdiploma.exception;

import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class InvalidGradeException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;

    public InvalidGradeException(double note){
        this.error = new ErrorDTO();
        this.error.setMessage("La nota " + note +" es invalida, la nota debe ser mayor a 0 y menor que 10");
        this.error.setName(this.getClass().getSimpleName());

        this.status = status;

    }
}
