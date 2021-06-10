package com.example.socialmeli.repositories;

import com.example.socialmeli.models.Post;

import java.util.List;

public interface IPostRepository {
    void newPost(Post post);
    Post getPostById(int postId);
    List<Post> getPostByUserId(Integer userId, String order);
    Integer promoCount(Integer useriD);
    List<Post> listPromoProductsByUserid(Integer userId);
}
