package com.meli.socialmeli.repositories;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.exceptions.UserIsNotMerchant;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;

public interface IPostRepository {

    UserMeli newPostAdd(Post post) throws UserIsNotMerchant;
    UserPostListDTO getPostListById(int userId, String order);
}
