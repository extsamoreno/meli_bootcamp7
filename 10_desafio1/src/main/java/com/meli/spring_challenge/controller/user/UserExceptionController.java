package com.meli.spring_challenge.controller.user;

import com.meli.spring_challenge.exception.user.*;
import com.meli.spring_challenge.service.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

        @ExceptionHandler(UserException.class)
        public ResponseEntity<ErrorDto> handleGlobalException(UserException e){
            return new ResponseEntity<>(e.getError(),e.getStatus());
        }

        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<ErrorDto> handleGlobalException(UserNotFoundException e){
            return new ResponseEntity<>(e.getError(),e.getStatus());
        }

        @ExceptionHandler(UserRelationNotFoundException.class)
        public ResponseEntity<ErrorDto> handleGlobalException(UserRelationNotFoundException e){
            return new ResponseEntity<>(e.getError(),e.getStatus());
        }

        @ExceptionHandler(UserNotSellerException.class)
        public ResponseEntity<ErrorDto> handleGlobalException(UserNotSellerException e){
            return new ResponseEntity<>(e.getError(),e.getStatus());
        }

        @ExceptionHandler(UserFollowException.class)
        public ResponseEntity<ErrorDto> handleGlobalException(UserFollowException e){
            return new ResponseEntity<>(e.getError(),e.getStatus());
        }
}
