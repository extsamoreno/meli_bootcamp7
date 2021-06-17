package desafio2.demo.controller;

import desafio2.demo.exception.ApiException;
import desafio2.demo.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDTO> returnError(ApiException e){
        return new ResponseEntity<>(e.getErrorDTO(),e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> returnError(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<>("Please verify that you are using the correct data types for this endpoint", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> returnError(HttpMessageNotReadableException e){
        return new ResponseEntity<>("The provided JSON can't be parsed. Please check that you are providing only the correct properties with the correct values", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var errorDTO = new ArrayList<ErrorDTO>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            var err = new ErrorDTO();
            err.setName("Validation error on property: "+((FieldError) error).getField());
            err.setMessage(error.getDefaultMessage());
            errorDTO.add(err);
        });
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<String> returnError(Exception e){
//        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }


}
