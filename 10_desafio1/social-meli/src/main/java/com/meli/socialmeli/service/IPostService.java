package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.*;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(NewPostDTO newPost) throws UserIdNotFoundException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
    void addPromoPost(NewPromoPostDTO newPromoPost) throws UserIdNotFoundException;
    PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException;
    UserPromoPostsDTO getUserPromoPosts(Integer userId) throws UserIdNotFoundException;
}
