package socialmeli.socialmeli.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.*;
import socialmeli.socialmeli.project.services.Dto.ErrorDto;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(NoPostsFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(NoPostsFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostPromoNotFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostPromoNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(PostPromoFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostPromoFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(InvalidPostDateException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(InvalidPostDateException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}
