package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;

public interface RepositoryUsers {
    public User getUserById(int userId);
    public Post getPostById(int postId);
    public boolean createNewPost(Post post);
}
