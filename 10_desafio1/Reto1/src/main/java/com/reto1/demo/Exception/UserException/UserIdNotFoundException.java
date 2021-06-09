package com.reto1.demo.Exception.UserException;

import com.reto1.demo.Exception.GeneralException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserIdNotFoundException extends GeneralException {
    public UserIdNotFoundException(int userId) {
        super("UserId: "+userId+" not found", HttpStatus.BAD_REQUEST);
    }
}
