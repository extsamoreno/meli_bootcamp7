package desafio1.desafio1.exception;

import desafio1.desafio1.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ValidateSellerException.class)
    public ResponseEntity<ErrorDTO> validateSellerException(ValidateSellerException e){
        return  new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ValidateUserException.class)
    public ResponseEntity<ErrorDTO> validateUserException(ValidateUserException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
