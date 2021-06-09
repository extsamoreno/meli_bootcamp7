package com.example.desafio1.exception;

import org.springframework.http.HttpStatus;

public class PostIdAlreadyInUseException extends CustomException{
    public PostIdAlreadyInUseException(int productId, int recomendedId)
    {
        super("The id: " + productId + " is already in use. Try with id " + recomendedId + " or higher.", HttpStatus.BAD_REQUEST);
    }
}
