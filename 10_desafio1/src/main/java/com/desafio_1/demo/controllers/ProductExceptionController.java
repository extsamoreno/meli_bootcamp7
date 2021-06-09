package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ErrorDTO;
import com.desafio_1.demo.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductIdPostInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdPostInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDateInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductCategoryInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductCategoryInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductPriceInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductPriceInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailIdInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailIdInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailNameRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailNameRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailBrandRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailBrandRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailColorRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailColorRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailTypeRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailTypeRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}
