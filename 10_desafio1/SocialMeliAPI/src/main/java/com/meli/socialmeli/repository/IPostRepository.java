package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;

import java.util.Comparator;
import java.util.List;

public interface IPostRepository {
    public Post getPostById(int postId);
    public void savePost(Post post);
    public List<Post> getPostsByUserId(int userId);
}
