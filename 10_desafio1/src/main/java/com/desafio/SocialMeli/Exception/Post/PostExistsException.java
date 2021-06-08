package com.desafio.SocialMeli.Exception.Post;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class PostExistsException extends SocialMeliException {

    public PostExistsException(int post_id) {
        super("Post with ID " + post_id + " already exists", HttpStatus.BAD_REQUEST);
    }
}
