package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.dto.NewPromoPostDTO;
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

    public static Post toPromoPost(NewPromoPostDTO newPromoPost) {
        Post post = new Post();
        post.setUserId(newPromoPost.getUserId());
        post.setPostId(newPromoPost.getPostId());
        post.setDate(newPromoPost.getDate());
        post.setDetail(newPromoPost.getDetail());
        post.setCategory(newPromoPost.getCategory());
        post.setPrice(newPromoPost.getPrice());
        post.setHasPromo(newPromoPost.isHasPromo());
        post.setDiscount(newPromoPost.getDiscount());
        return post;
    }
}
