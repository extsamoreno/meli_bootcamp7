package com.meli.SocialMeli.exception;

public class InvalidUserNameException extends UserException{
    public InvalidUserNameException() {
        super("The username is not valid");
    }
}
