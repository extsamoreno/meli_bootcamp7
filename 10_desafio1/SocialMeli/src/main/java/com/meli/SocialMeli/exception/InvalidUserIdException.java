package com.meli.SocialMeli.exception;

public class InvalidUserIdException extends UserException{
    public InvalidUserIdException() {
        super("User ID not valid");
    }
}
