package com.example.desafiospring.socialmeli.exception;


import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {


    /**
     * EXCEPTIONS HANDLER:
     * usernotfound
     * failcreatepost
     * dateisnotvalid
     * postidalready
     */

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(FailCreatePostException.class)
    public ResponseEntity<ErrorDTO> failCreatePostException(FailCreatePostException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DateIsNotValidException.class)
    public ResponseEntity<ErrorDTO> invalidDateException(DateIsNotValidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(PostIdAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus()); //exception handler, nos devuelve el ERROR de dto
    }

}
