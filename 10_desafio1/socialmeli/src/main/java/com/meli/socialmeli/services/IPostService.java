package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;

public interface IPostService {

    UserMeli newPost(Post post);
    UserPostListDTO getListPosts(int userId);

}
