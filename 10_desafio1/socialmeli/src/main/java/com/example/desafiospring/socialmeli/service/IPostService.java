package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;

public interface IPostService {
    public void newPost(PostDTO post) throws UserNotFoundException;
}
