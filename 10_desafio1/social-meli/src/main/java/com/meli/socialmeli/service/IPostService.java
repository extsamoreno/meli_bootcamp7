package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.post.*;
import com.meli.socialmeli.dto.user.UserPromoPostsDTO;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(PostDTO newPost) throws UserIdNotFoundException, PostAlreadyInsertedException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
    void addPromoPost(PostDTO newPromoPost) throws UserIdNotFoundException, PostAlreadyInsertedException;
    PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException;
    UserPromoPostsDTO getUserPromoPosts(Integer userId) throws UserIdNotFoundException;
}
