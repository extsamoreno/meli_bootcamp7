package com.springChallenge.api.controller.exception.user;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@Getter
public class UserNotFoundException extends UserValidationsException {
    public UserNotFoundException(int userId){
        super(MessageFormat.format("The userId ''{0}'' does not exist", userId), HttpStatus.BAD_REQUEST);
    }
}
