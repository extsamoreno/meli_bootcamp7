package com.meli.spring_challenge.exception.product;

import org.springframework.http.HttpStatus;

public class ProductIDAlreadyExistException extends ProductException{
    public ProductIDAlreadyExistException(int productID){
        super("The productID: " + productID + " already exists!", HttpStatus.BAD_REQUEST);
    }
}
