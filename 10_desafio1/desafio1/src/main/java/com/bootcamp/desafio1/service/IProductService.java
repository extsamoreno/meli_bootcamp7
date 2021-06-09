package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.dto.response.CountPromoDTO;
import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.PostNotFoundException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;
import com.bootcamp.desafio1.exception.UserNotFoundException;

public interface IProductService {

    void insertNewPost(NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException, UserNotFoundException;

    CountPromoDTO promoCount(int userId) throws UserNotFoundException, PostNotFoundException;
}
