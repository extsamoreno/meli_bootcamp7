package com.linktracker.api.controller;

import com.linktracker.api.exception.*;
import com.linktracker.api.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class  LinkTrackerExceptionController{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkTrackerBadIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerBadIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(LinkTrackerBadPasswordException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerBadPasswordException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}


