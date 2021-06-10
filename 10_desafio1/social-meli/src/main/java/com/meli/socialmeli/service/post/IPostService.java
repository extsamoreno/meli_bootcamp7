package com.meli.socialmeli.service.post;

import com.meli.socialmeli.dto.post.*;
import com.meli.socialmeli.dto.user.UserPromoPostsDTO;
import com.meli.socialmeli.exception.InvalidDateException;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.ProductAlreadyPostedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IPostService {
    void addPost(PostDTO newPost) throws UserIdNotFoundException, PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException;
    FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException;
    void addPromoPost(PostDTO newPromoPost) throws UserIdNotFoundException, PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException;
    PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException;
    UserPromoPostsDTO getUserPromoPosts(Integer userId) throws UserIdNotFoundException;
}
