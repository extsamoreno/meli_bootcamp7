package com.example.Challenge.exception;

import com.example.Challenge.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException{
    public UserIdNotFoundException(Integer idUser) {
        super("Id:  "+ idUser+" does not correspond to any user", HttpStatus.BAD_REQUEST);
    }
}
