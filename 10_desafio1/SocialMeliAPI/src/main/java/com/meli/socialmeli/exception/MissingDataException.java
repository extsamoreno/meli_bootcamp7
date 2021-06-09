package com.meli.socialmeli.exception;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.PromotionPost;
import org.springframework.http.HttpStatus;

public class MissingDataException extends PostException{
    public MissingDataException(Post post){
        super("The post with id "+post.getId_post()+" has one or more null/invalid values", HttpStatus.BAD_REQUEST);
    }
    public MissingDataException(PromotionPost post){
        super("The post with id "+post.getId_post()+" has one or more null/invalid values", HttpStatus.BAD_REQUEST);
    }
}
