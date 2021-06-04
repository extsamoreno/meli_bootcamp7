package bootcamp.cuatro.spring.controller;

import bootcamp.cuatro.spring.exception.LinkException;
import bootcamp.cuatro.spring.exception.LinkNotFoundException;
import bootcamp.cuatro.spring.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkException e){
        return new ResponseEntity<ErrorDTO>(e.getError(),e.getStatus());
    }
}
