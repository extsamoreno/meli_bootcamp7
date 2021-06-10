package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.dtos.PostDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedPostsDTO;

public interface IProductService {
    void addNewProductWithPost(PostDTO postDTO) throws ProductInsertException, PostInsertException, ObjectNotFoundException, ObjectExistException;

    UserWithFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException, ObjectNotFoundException, UserDistinctTypeException;
}
