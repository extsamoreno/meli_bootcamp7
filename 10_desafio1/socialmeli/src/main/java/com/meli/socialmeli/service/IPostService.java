package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;
import com.meli.socialmeli.service.dto.ProductsUserDTO;

import java.util.List;

public interface IPostService {

    void addPost(PostDTO post) throws PostDateBeforeToday, PostNotExistsException, PostAlreadyExists, UserNotExistsException;

    void updatePost(PostDTO post) throws PostNotExistsException, PostDateBeforeToday;

    void addPromoPost(PostDTO post) throws PostDateBeforeToday, PostNotExistsException, PostAlreadyExists, UserNotExistsException;

    List<PostDTO> getListPostByUserId(int userId);

    ProductsUserDTO getProductsPromoPostByUserId(int userId, String order) throws UserNotExistsException;

    PostFollowingDTO getListPostUsersFollowingByUserId(int userId, String order) throws UserNotExistsException, MissingParameterException;

    PostFollowingDTO getListPromoPostUsersFollowingByUserId(int userId, String order) throws UserNotExistsException;

    int countProductPromoByUserId(int userId) throws UserNotExistsException;



}
