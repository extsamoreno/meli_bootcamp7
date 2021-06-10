package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoCountDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.exceptions.PostAlreadyExistsException;

import java.util.List;

public interface IProductService {
    void processNewPost(PostDTO post) throws PostAlreadyExistsException;

    List<PostDTO> getFollowedPosts(int userId, String order) throws OrderNotValidException;

    List<PostDTO> getPromoPosts(int userId);

    PostPromoCountDTO getPromoPostsCount(int userId);
}
