package com.example.SocialMeli.Controllers;



import com.example.SocialMeli.Exceptions.ProductIdInUseException;
import com.example.SocialMeli.Exceptions.ProductNotFoundException;
import com.example.SocialMeli.Services.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductIdInUseException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdInUseException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleDateExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage().split(" \\(")[0], ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }
}
