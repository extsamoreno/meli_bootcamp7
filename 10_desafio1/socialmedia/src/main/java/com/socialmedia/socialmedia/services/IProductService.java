package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.dtos.*;

public interface IProductService {
    void addNewProductWithPost(PostDTO postDTO) throws ProductInsertException, PostInsertException, ObjectNotFoundException, ObjectExistException;

    UserWithFollowedPostsDTO getFollowedPostsByUser(int userId, String order) throws UserNotFoundException, ObjectNotFoundException, UserDistinctTypeException;

    void addNewProductPromoWithPost(PostPromoDTO postPromoDTO) throws ObjectExistException, ObjectNotFoundException, ProductInsertException, PostInsertException;

    UserCountPromoDTO getCountPromosByUser(int userId) throws ObjectNotFoundException, UserDistinctTypeException;

    UserWithPromosDTO getPromosByUser(int userId) throws ObjectNotFoundException, UserDistinctTypeException;
}
