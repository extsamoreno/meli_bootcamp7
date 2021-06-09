package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.PostIdAlreadyInUseException;
import com.example.desafio1.model.ProductPost;

import java.util.HashMap;

public interface IPostService {

    String createPost(ProductPost productPost)
            throws ProductNotFoundException, ProductInconsistencyException, PostIdAlreadyInUseException;
    ProductPost checkPostId(ProductPost postRequest)
            throws PostIdAlreadyInUseException;
    HashMap<Integer, ProductPost> getPosts();
}
