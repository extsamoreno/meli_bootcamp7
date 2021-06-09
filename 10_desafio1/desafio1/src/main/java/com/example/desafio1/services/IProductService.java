package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.ResponseFollowedPostDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.exceptions.UserException;

public interface IProductService {
    String addNewPost(PostDTO postDTO) throws InvalidUserIdException;
    ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId, String order) throws UserException;
}
