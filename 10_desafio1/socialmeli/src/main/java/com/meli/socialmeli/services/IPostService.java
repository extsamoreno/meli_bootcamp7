package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.exceptions.UserIsNotMerchant;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;

public interface IPostService {

    void newPost(Post post) throws UserIsNotMerchant;
    UserPostListDTO getListPosts(int userId, String order);

}
