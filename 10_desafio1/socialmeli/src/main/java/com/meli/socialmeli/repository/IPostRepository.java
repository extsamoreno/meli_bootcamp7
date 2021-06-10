package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {

    void addPost(Post post);

    void updatePost(Post post);

    List<Post> getListPostByUserId(int userId);

    List<Post> getListPromoPostByUserId(int userId);

    int countProductPromoByUserId(int userId);

    Post getPostByUserIdPostIdProductId(int userId, int postId, int productId);

    Post getPostByPostId(int postId);
}
