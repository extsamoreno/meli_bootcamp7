package com.springChallenge.api.service.contract;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;

public interface IProductService {
    void createNewPost(PostDTO postDTO) throws UserNotFoundException;

    PostsListDTO getPostsByUserId(Integer userId, String order) throws UserNotFoundException;
}
