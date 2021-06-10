package com.meli.socialmeli.repository;

import com.meli.socialmeli.exception.OverActualDateException;
import com.meli.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {
    public Post getPostById(int postId);
    public void savePost(Post post) throws OverActualDateException;
    public List<Post> getPostsByUserId(int userId);
    public List<Post> getPromotionPostByUserId(int userId);
}
