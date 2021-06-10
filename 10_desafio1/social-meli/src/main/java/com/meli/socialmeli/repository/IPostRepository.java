package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;

import java.util.List;

public interface IPostRepository {
    boolean insertPost(Post post);
    List<Post> getFollowedPosts(List<User> followed, String order);
    List<Post> getPromoPosts(Integer userId);
}
