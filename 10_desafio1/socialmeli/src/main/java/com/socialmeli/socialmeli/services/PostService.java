package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.dtos.PostDTO;

public interface PostService {
    public void newPost(PostDTO post) throws UserNotFoundException;
}
