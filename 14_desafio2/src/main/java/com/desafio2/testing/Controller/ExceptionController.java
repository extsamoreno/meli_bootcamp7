package com.desafio2.testing.Controller;

import com.desafio2.testing.Dto.ErrorDTO;
import com.desafio2.testing.Exception.BarrioNoExistException;
import com.desafio2.testing.Exception.BarrioYaExistente;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Exception.PropiedadYaRegistradaException;
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

        ArrayList<ErrorDTO> errores = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            ErrorDTO errorDto= new ErrorDTO(name,message);
            errores.add(errorDto);
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropiedadInexistenteException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropiedadInexistenteException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(BarrioNoExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(BarrioNoExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


    @ExceptionHandler(PropiedadYaRegistradaException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropiedadYaRegistradaException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(BarrioYaExistente.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(BarrioYaExistente e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
