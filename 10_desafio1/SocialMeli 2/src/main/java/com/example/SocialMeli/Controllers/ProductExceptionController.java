package com.example.SocialMeli.Controllers;



import com.example.SocialMeli.Exceptions.ProductIdInUseException;
import com.example.SocialMeli.Exceptions.ProductNotFoundException;
import com.example.SocialMeli.Services.DTOs.ErrorDTO;
import org.springframework.http.ResponseEntity;
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
}
