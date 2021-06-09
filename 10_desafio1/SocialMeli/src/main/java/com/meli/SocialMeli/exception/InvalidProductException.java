package com.meli.SocialMeli.exception;

public class InvalidProductException extends ProductException{
    public InvalidProductException() {
        super("Product details are not valid.");
    }
}
