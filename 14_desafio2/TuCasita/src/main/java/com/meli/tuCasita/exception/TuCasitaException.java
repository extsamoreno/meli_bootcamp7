package com.meli.tuCasita.exception;


import com.meli.tuCasita.model.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class TuCasitaException extends RuntimeException {

    private  ErrorDTO error;
    private  HttpStatus status;

    public TuCasitaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}