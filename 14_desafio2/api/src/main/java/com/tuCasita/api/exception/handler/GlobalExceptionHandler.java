package com.tuCasita.api.exception.handler;

import com.tuCasita.api.exception.dto.ErrorDTO;
import com.tuCasita.api.exception.dto.ValidationsErrorDTO;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DistrictNameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNameNotFoundException(DistrictNameNotFoundException ex){
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationsErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(
                new ValidationsErrorDTO(e.getBindingResult().getAllErrors(), e.getClass().getSimpleName()),
                HttpStatus.BAD_REQUEST);
    }
}
