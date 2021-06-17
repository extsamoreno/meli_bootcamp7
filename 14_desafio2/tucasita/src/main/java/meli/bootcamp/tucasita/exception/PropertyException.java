package meli.bootcamp.tucasita.exception;

import lombok.Getter;
import meli.bootcamp.tucasita.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends Exception{

    private final ErrorDTO error;
    private final HttpStatus status;

    public PropertyException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
