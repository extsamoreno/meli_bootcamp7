package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.model.Post;

public class PostMapper {
    public static Post toPost(NewPostDTO newPost) {
        Post post = new Post();

        post.setUserId(newPost.getUserId());
        post.setPostId(newPost.getPostId());
        post.setDate(newPost.getDate());
        post.setDetail(newPost.getDetail());
        post.setCategory(newPost.getCategory());
        post.setPrice(newPost.getPrice());

        return post;
    }
}
