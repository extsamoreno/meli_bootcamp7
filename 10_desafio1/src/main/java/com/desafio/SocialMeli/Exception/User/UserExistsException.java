package com.desafio.SocialMeli.Exception.User;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class UserExistsException extends SocialMeliException {

    public UserExistsException(String userName) {
        super("ID "+userName+" already exists", HttpStatus.BAD_REQUEST);
    }
}
