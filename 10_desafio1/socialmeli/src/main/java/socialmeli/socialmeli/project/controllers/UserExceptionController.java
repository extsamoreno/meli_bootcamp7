package socialmeli.socialmeli.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import socialmeli.socialmeli.project.exceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ErrorDto;

import java.io.FileNotFoundException;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(IdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowMyselfException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(FollowMyselfException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowAlreadyException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(FollowAlreadyException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
