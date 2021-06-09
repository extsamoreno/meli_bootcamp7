package com.example.demo.services;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostListDTO;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

public interface IProductServices {

    void newPost(PostDTO post) throws UserNotFoundException;

    PostListDTO getPostList(Integer userId, String order);
}
