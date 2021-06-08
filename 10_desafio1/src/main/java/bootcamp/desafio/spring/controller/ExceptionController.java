package bootcamp.desafio.spring.controller;


import bootcamp.desafio.spring.exception.UserException;
import bootcamp.desafio.spring.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<ErrorDTO>(e.getError(),e.getStatus());
    }
}
