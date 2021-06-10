package com.example.desafio1.service;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.service.dto.post.ResponseListFollowedSellers;
import com.example.desafio1.service.dto.post.ResponseListPostDTO;
import com.example.desafio1.service.dto.post.ResponseListPromoDTO;
import com.example.desafio1.service.dto.post.ResponsePromoPostCountDTO;

public interface iPostService {

    void createPost(Post post) throws PostAlreadyExistException, UserNotFoundException;
    ResponseListFollowedSellers listPostsFollowed(Integer userId, String order) throws UserNotFoundException;
    ResponseListPostDTO lastSellerPosts(Integer userId, String order) throws UserNotFoundException;
    ResponsePromoPostCountDTO countPromoPostSeller(Integer userId) throws UserNotFoundException;
    ResponseListPromoDTO listSellerPromoPosts(Integer userId, String order) throws UserNotFoundException;
}
