package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {

    void addPost(Post post);

    List<Post> getListPostByUserId(int userId);

    List<Post> getListPromoPostByUserId(int userId);
}
