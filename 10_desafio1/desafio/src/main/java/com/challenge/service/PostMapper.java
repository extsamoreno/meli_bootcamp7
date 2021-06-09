package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.dto.NewPromoPostRequest;
import com.challenge.dto.PostDTO;
import com.challenge.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static Post toPost(NewPostRequest request) {
        Post post = new Post();
        post.setCategory(request.getCategory());
        post.setDetail(request.getDetail());
        post.setPrice(request.getPrice());
        post.setPostId(request.getPostId());
        post.setDate(request.getDate());
        post.setUserId(request.getUserId());
        post.setHasPromo(false);
        post.setDiscount((double) 0);
        return post;
    }

    public static Post toPromoPost(NewPromoPostRequest request) {
        Post post = new Post();
        post.setCategory(request.getCategory());
        post.setDetail(request.getDetail());
        post.setPrice(request.getPrice());
        post.setPostId(request.getPostId());
        post.setDate(request.getDate());
        post.setUserId(request.getUserId());
        post.setDiscount(request.getDiscount());
        post.setHasPromo(request.getHasPromo());
        return post;
    }

    public static PostDTO toPostDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setCategory(post.getCategory());
        dto.setDate(post.getDate());
        dto.setPostId(post.getPostId());
        dto.setPrice(post.getPrice());
        dto.setUserId(post.getUserId());
        dto.setDetail(post.getDetail());
        if (post.getHasPromo()) {
            dto.setHasPromo(post.getHasPromo());
            dto.setDiscount(post.getDiscount());
        }
        return dto;
    }

    public static List<PostDTO> toDtoList(List<Post> list) {
        List<PostDTO> dtoList = new ArrayList<>();
        list.forEach(p -> {
            dtoList.add(toPostDto(p));
        });
        return dtoList;
    }
}
