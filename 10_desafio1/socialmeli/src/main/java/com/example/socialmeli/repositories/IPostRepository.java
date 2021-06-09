package com.example.socialmeli.repositories;

import com.example.socialmeli.dtos.PostListDTO;
import com.example.socialmeli.models.Post;

import java.util.List;

public interface IPostRepository {
    void newPost(Post post);
    Post getPostById(int postId);
    List<Post> getPostByUserId(Integer userId);
}
