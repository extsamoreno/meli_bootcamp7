package com.obtenerdiploma.validaciones.Controller;


import com.obtenerdiploma.validaciones.Dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {


   /* @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ErrorDTO> handleGlobalException(MethodArgumentNotValidException e){
       return new ResponseEntity<>(new ErrorDTO(e.getMessage(),e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
   }
*/

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



}
