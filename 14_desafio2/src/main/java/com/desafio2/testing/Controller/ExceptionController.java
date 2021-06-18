package com.desafio2.testing.Controller;

import com.desafio2.testing.Dto.ErrorDTO;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.ExistentDistrictException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;


@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        ArrayList<ErrorDTO> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            ErrorDTO errorDto= new ErrorDTO(name,message);
            errors.add(errorDto);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyNonExistentException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyNonExistentException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DistrictNonExistentException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNonExistentException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


    @ExceptionHandler(ExistenPropertyException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ExistenPropertyException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ExistentDistrictException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ExistentDistrictException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
