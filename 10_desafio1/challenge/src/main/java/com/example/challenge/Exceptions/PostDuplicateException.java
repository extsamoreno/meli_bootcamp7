package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class PostDuplicateException extends ApiException {

    public PostDuplicateException(int postId){
        super("The id :"+postId+" is already present in another post for this user", HttpStatus.BAD_REQUEST);

    }
}
