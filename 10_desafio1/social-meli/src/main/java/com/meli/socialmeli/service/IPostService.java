package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowedPostsDTO;
import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.dto.NewPromoPostDTO;
import com.meli.socialmeli.dto.PromoPostCount;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(NewPostDTO newPost) throws UserIdNotFoundException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
    void addPromoPost(NewPromoPostDTO newPromoPost) throws UserIdNotFoundException;
    PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException;
}
