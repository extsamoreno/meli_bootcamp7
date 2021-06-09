package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;

import java.util.List;

public interface IPostRepository {
    void insertPost(Post post);
    List<Post> getFollowedPosts(List<User> followed);
}
