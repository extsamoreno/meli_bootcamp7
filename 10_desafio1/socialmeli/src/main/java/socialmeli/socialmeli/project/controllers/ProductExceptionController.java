package socialmeli.socialmeli.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.services.Dto.ErrorDto;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
