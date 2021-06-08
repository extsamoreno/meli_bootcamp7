package com.desafio.SocialMeli.Exception.User;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends SocialMeliException {

    public UserIdNotFoundException(Integer userId) {
        super("ID "+userId+" does not belong to any user", HttpStatus.BAD_REQUEST);
    }
}
