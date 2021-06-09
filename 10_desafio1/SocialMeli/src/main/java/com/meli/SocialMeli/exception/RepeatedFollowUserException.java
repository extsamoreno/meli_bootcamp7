package com.meli.SocialMeli.exception;

public class RepeatedFollowUserException extends UserException{
    public RepeatedFollowUserException() {
        super("this user already follows the selected seller");
    }
}
