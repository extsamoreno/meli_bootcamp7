package com.digitalhouse.obtenerdiploma.exceptions;
import com.digitalhouse.obtenerdiploma.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SubjectException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;

    public SubjectException(String message, HttpStatus status){
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}