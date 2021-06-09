package com.example.DesafioSpring.exceptions;
import org.springframework.http.HttpStatus;
public class ProductTakenException extends ProductException{
    public ProductTakenException(int productId) {
        super("Product ID: "+productId+" is already taken", HttpStatus.BAD_REQUEST);
    }
}
