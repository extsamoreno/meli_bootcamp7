package desafio2.testing.controller;

import desafio2.testing.exception.DistrictException;
import desafio2.testing.exception.ErrorDTO;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(NotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseExistException.class)
    public ResponseEntity<ErrorDTO> houseExistException(HouseExistException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictException.class)
    public ResponseEntity<ErrorDTO> districtException(DistrictException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
