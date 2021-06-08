package com.reto1.demo.Exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserIdNotFoundException extends UserException {
    public UserIdNotFoundException(int userId) {
        super("UserId: "+userId+" not found", HttpStatus.BAD_REQUEST);
    }
}
