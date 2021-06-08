package desafio1.demo.Controller;

import desafio1.demo.Exception.UserException;
import desafio1.demo.Model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> returnError(UserException e){
        return new ResponseEntity<>(e.getErrorDTO(),e.getHttpStatus());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> returnError(Exception e){
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
