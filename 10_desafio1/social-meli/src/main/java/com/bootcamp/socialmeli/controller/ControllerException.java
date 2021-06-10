package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.ErrorDTO;
import com.bootcamp.socialmeli.exception.FollowYourselfException;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UnfollowYourselfException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerException {


    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserIdNotFound(UserIdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(PostAlreadyRegisteredException.class)
    public ResponseEntity<ErrorDTO> handlePostAlreadyRegistered(PostAlreadyRegisteredException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(FollowYourselfException.class)
    public ResponseEntity<ErrorDTO> handleFollowYourSelf(FollowYourselfException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(UnfollowYourselfException.class)
    public ResponseEntity<ErrorDTO> handleUnfollowYourSelf(UnfollowYourselfException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorDTO> handleDateTimeParse(DateTimeParseException e) {
        ErrorDTO error = new ErrorDTO();
        error.setMessage("Invalid date format");
        error.setName(e.getClass().getSimpleName());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
