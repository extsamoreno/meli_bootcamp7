package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import com.example.desafiospring.socialmeli.service.DTO.PostListDTO;


public interface IPostService {
    public void newPost(PostDTO post) throws UserNotFoundException;

    public PostListDTO getFollowedPostList(int userId) throws UserNotFoundException;
}
