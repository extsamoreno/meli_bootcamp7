package com.springChallenge.api.service.contract;

import com.springChallenge.api.controller.dto.product.CountPromoDTO;
import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.product.IDPostAlreadyUsed;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;

public interface IProductService {
    void createNewPost(PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed;

    PostsListDTO getPostsByFollowed(Integer userId, String order) throws UserNotFoundException;

    CountPromoDTO getCountPromo(Integer userId) throws UserNotFoundException;

    PostsListDTO getPromoPostsById(Integer userId) throws UserNotFoundException;
}
