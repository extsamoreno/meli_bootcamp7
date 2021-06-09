package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.PostInsertException;
import com.socialmedia.socialmedia.exceptions.ProductInsertException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.services.dtos.PostDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedPostsDTO;

public interface IProductService {
    void addNewProductWithPost(PostDTO postDTO) throws ProductInsertException, PostInsertException;

    UserWithFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException;
}
