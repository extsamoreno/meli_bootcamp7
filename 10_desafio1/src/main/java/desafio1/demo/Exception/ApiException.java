package desafio1.demo.Exception;

import desafio1.demo.Model.DTO.ErrorDTO;
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
