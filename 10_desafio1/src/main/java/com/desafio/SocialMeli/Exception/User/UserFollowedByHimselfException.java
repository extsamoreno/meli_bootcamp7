package com.desafio.SocialMeli.Exception.User;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class UserFollowedByHimselfException extends SocialMeliException {
    public UserFollowedByHimselfException(Integer userId) {
        super("ID "+userId+" cannot be followed by himself", HttpStatus.CONFLICT);
    }
}
