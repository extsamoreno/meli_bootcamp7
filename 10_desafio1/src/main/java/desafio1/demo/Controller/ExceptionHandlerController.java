package desafio1.demo.Controller;

import desafio1.demo.Exception.ApiException;
import desafio1.demo.Model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> returnError(Exception e){
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
