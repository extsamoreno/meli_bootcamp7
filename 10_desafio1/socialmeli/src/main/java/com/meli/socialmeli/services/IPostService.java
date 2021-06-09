package com.meli.socialmeli.services;

import com.meli.socialmeli.dto.UserPostListODT;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.stereotype.Service;

public interface IPostService {

    UserMeli newPost(Post post);
    UserPostListODT getListPosts(int userId);

}
