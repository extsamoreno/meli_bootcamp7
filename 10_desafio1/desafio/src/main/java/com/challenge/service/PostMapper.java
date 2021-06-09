package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.entity.Post;

public class PostMapper {

    public static Post toPost(NewPostRequest request) {
        Post post = new Post();
        post.setCategory(request.getCategory());
        post.setDetail(request.getDetail());
        post.setPrice(request.getPrice());
        post.setPostId(request.getPostId());
        post.setDate(request.getDate());
        post.setUserId(request.getUserId());
        return post;
    }
}
