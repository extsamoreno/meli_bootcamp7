package com.meli.socialmeli.repositories;

import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;

public interface IPostRepository {

    UserMeli newPostAdd(Post post);
    UserMeli getPostListById(int userId);
}
