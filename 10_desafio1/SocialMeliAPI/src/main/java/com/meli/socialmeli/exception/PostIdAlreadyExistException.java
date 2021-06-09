package com.meli.socialmeli.exception;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.PromotionPost;
import org.springframework.http.HttpStatus;

public class PostIdAlreadyExistException extends PostException{
    public PostIdAlreadyExistException(Post post){
        super("The id "+post.getId_post()+" is already assigned to a post", HttpStatus.BAD_REQUEST);
    }
    public PostIdAlreadyExistException(PromotionPost post){
        super("The id "+post.getId_post()+" is already assigned to a post", HttpStatus.BAD_REQUEST);
    }
}
