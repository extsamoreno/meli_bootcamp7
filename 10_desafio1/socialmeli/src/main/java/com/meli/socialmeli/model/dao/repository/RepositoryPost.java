package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.model.dao.model.Post;

public interface RepositoryPost {
    Post getPostById(int postId);
    boolean createNewPost(Post post);
}
