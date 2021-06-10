package com.desafiospring.socialMeli.service.mapper;

import com.desafiospring.socialMeli.dto.NewPostDTO;
import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.dto.NewPromoPostDTO;
import com.desafiospring.socialMeli.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static PostDTO toPostDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setCategory(post.getCategory());
        dto.setDate(post.getDate());
        dto.setId_post(post.getId_post());
        dto.setPrice(post.getPrice());
        dto.setUserId(post.getUserId());
        dto.setDetail(post.getDetail());
        if (post.isHasPromo()) {
            dto.setHasPromo(post.isHasPromo());
            dto.setDiscount(post.getDiscount());
        }
        return dto;
    }

    public static Post toPost(NewPostDTO newPost) {
        Post post = new Post();
        post.setUserId(newPost.getUserId());
        post.setId_post(newPost.getId_post());
        post.setDate(newPost.getDate());
        post.setDetail(newPost.getDetail());
        post.setCategory(newPost.getCategory());
        post.setPrice(newPost.getPrice());
        return post;
    }

    public static Post toPromoPost(NewPromoPostDTO newPromoPost) {
        Post post = new Post();
        post.setUserId(newPromoPost.getUserId());
        post.setId_post(newPromoPost.getId_post());
        post.setDate(newPromoPost.getDate());
        post.setDetail(newPromoPost.getDetail());
        post.setCategory(newPromoPost.getCategory());
        post.setPrice(newPromoPost.getPrice());
        post.setHasPromo(newPromoPost.isHasPromo());
        post.setDiscount(newPromoPost.getDiscount());
        return post;
    }


    public static List<PostDTO> toDtoList(List<Post> list) {
        List<PostDTO> dtoList = new ArrayList<>();
        list.forEach(p -> {
            dtoList.add(toPostDto(p));
        });
        return dtoList;
    }
}

