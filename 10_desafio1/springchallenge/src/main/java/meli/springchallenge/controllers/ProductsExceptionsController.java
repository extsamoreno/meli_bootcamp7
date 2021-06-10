package meli.springchallenge.controllers;

import meli.springchallenge.dtos.ErrorDTO;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.SocialMeliException;
import meli.springchallenge.exceptions.UserNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductsExceptionsController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostIdNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdNotValidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ProductIdNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdNotValidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
