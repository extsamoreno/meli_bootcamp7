package desafio1.desafio1.exception;

import desafio1.desafio1.service.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends Exception{
    private ErrorDTO error;
    private HttpStatus status;
}
