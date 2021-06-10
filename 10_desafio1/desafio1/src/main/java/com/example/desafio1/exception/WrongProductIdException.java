package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class WrongProductIdException extends CustomException{
    public WrongProductIdException(int productId)
    {
        super("This product already have a valid Id. " +
                "Valid Id: " + productId, HttpStatus.BAD_REQUEST);
    }
}
