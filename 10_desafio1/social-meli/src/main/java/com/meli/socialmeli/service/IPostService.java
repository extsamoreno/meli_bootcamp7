package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.post.FollowedPostsDTO;
import com.meli.socialmeli.dto.post.NewPostDTO;
import com.meli.socialmeli.dto.post.NewPromoPostDTO;
import com.meli.socialmeli.dto.post.PromoPostCount;
import com.meli.socialmeli.dto.user.UserPromoPostsDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(NewPostDTO newPost) throws UserIdNotFoundException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
    void addPromoPost(NewPromoPostDTO newPromoPost) throws UserIdNotFoundException;
    PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException;
    UserPromoPostsDTO getUserPromoPosts(Integer userId) throws UserIdNotFoundException;
}
