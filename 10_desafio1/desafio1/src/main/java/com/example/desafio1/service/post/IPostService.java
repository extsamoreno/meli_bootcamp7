package com.example.desafio1.service.post;

import com.example.desafio1.exception.*;
import com.example.desafio1.model.ProductPost;
import com.example.desafio1.service.dto.postdto.PostDTO;
import com.example.desafio1.service.dto.postdto.UserPostListDTO;

import java.util.HashMap;

public interface IPostService {

    String createPost(PostDTO postDTO)
            throws ProductNotFoundException, ProductInconsistencyException, PostIdAlreadyInUseException, WrongProductIdException;
    ProductPost checkPostId(ProductPost postRequest)
            throws PostIdAlreadyInUseException;
    HashMap<Integer, ProductPost> getPosts();
    UserPostListDTO getUserPostListDTO(int userId, String order) throws UserNotFoundException;
}
