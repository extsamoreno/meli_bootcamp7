package com.meli.spring_challenge.repository.newpost;

import com.meli.spring_challenge.model.Post;

import java.util.List;

public interface NewPostRepository {
    void create(Post post);
    List<Post> getPostsByUserID(int userID);
    Post getPostById(int postID);
}
