package com.meli.spring_challenge.service.product;

import com.meli.spring_challenge.exception.UserNotFoundException;
import com.meli.spring_challenge.model.Post;
import com.meli.spring_challenge.service.dto.FollowedSellerCountDto;
import com.meli.spring_challenge.service.dto.FollowedSellerDto;

public interface ProductService {
    void createNewPost(Post post) throws UserNotFoundException;
    FollowedSellerDto getFollowedSellerByID(int userID, String order) throws UserNotFoundException;
    FollowedSellerCountDto getFollowedSellerCount(int userID) throws UserNotFoundException;
    FollowedSellerDto getFollowedSellerPromoByID(int userID) throws UserNotFoundException;
}
