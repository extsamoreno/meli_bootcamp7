package com.reto1.demo.Exception.UserException;

import com.reto1.demo.Exception.GeneralException;
import org.springframework.http.HttpStatus;

public class SameIdException extends GeneralException {
    public SameIdException() {
        super("UserId and UserIdToFollow are equals", HttpStatus.BAD_REQUEST);
    }
}
