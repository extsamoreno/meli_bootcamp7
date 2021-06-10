package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.dto.response.CountPromoDTO;
import com.bootcamp.desafio1.dto.response.PostsFollowedListDTO;
import com.bootcamp.desafio1.dto.response.PromoListDTO;
import com.bootcamp.desafio1.exception.*;

public interface IProductService {

    void insertNewPost(NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException, UserNotFoundException;

    PostsFollowedListDTO listPostsFollowed(int userId, String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;

    CountPromoDTO promoCount(int userId) throws UserNotFoundException, PostNotFoundException;

    PromoListDTO listPromos(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException;
}
