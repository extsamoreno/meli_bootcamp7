package com.meli.socialmeli.exception;

import com.meli.socialmeli.model.Post;
import org.springframework.http.HttpStatus;

public class MissingDataException extends PostException{
    public MissingDataException(Post post){
        super("The post with id "+post.getId_post()+" has one or more null/invalid values", HttpStatus.BAD_REQUEST);
    }
}
