package com.example.DesafioSpring.exceptions;
import org.springframework.http.HttpStatus;
public class PostTakenException extends PostException {
    public PostTakenException(int postId) {
        super("Post ID: " + postId + " is already taken", HttpStatus.BAD_REQUEST);
    }
}
