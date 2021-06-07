package linktracker.demo.Exception;

import linktracker.demo.Model.DTO.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkException extends Exception{
    ErrorDTO errorDTO = new ErrorDTO();
    HttpStatus httpStatus;

    public LinkException(String message, HttpStatus httpStatus) {
        this.errorDTO.setMessage(message);
        this.errorDTO.setName(this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }
}
