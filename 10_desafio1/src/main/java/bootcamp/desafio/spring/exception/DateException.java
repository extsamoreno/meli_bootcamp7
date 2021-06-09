package bootcamp.desafio.spring.exception;

import bootcamp.desafio.spring.service.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DateException extends Exception{


    private ErrorDTO error;
    private HttpStatus status;

    public DateException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }

}
