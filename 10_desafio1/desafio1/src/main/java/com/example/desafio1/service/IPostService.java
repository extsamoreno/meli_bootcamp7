package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.PostIdAlreadyInUseException;
import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.ProductPost;
import com.example.desafio1.service.dto.postdto.PostDTO;
import com.example.desafio1.service.dto.postdto.UserPostListDTO;

import java.util.HashMap;

public interface IPostService {

    String createPost(PostDTO postDTO)
            throws ProductNotFoundException, ProductInconsistencyException, PostIdAlreadyInUseException;
    ProductPost checkPostId(ProductPost postRequest)
            throws PostIdAlreadyInUseException;
    HashMap<Integer, ProductPost> getPosts();
    UserPostListDTO getUserPostListDTO(int userId, String order) throws UserNotFoundException;
}
