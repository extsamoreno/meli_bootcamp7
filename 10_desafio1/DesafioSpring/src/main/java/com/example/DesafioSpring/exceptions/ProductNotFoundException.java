package com.example.DesafioSpring.exceptions;
import org.springframework.http.HttpStatus;
public class ProductNotFoundException extends ProductException{
    public ProductNotFoundException(int productId) {
        super("Product: "+productId+" not found", HttpStatus.BAD_REQUEST);
    }
}
