package desafio2.demo.exception;

import desafio2.demo.model.ErrorDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends Exception{
    ErrorDTO errorDTO = new ErrorDTO();
    HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        this.errorDTO.setMessage(message);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }
}
