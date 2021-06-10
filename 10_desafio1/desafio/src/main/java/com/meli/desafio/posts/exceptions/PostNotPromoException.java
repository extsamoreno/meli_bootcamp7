package com.meli.desafio.posts.exceptions;

import com.meli.desafio.exceptions.models.ExceptionModel;
import org.springframework.http.HttpStatus;

public class PostNotPromoException extends ExceptionModel {
    public PostNotPromoException(){
        super("this post has not a promo", HttpStatus.BAD_REQUEST);
    }
}
