package desafio2.testing.controller;

import desafio2.testing.exception.ErrorDTO;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HandlerExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(NotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseExistException.class)
    public ResponseEntity<ErrorDTO> houseExistException(HouseExistException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
