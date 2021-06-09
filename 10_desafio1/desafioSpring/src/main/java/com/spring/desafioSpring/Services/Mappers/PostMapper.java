package com.spring.desafioSpring.Services.Mappers;

import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.DTOs.PostWithoutIdUserDTO;
import com.spring.desafioSpring.Models.Post;

public class PostMapper {

    public static Post postDtoToPost(PostDTO dto){
        Post post = new Post();
        post.setUserId(dto.getUserId());
        post.setId_post(dto.getId_post());
        post.setDate(dto.getDate());
        post.setDetail(dto.getDetail());
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        post.setHasPromo(dto.isHasPromo());
        post.setDiscount(dto.getDiscount());
        return post;
    }

    public static PostWithoutIdUserDTO postToPostWithoutIdUserDTO(Post post){
        PostWithoutIdUserDTO dto = new PostWithoutIdUserDTO();
        dto.setId_post(post.getId_post());
        dto.setDate(post.getDate());
        dto.setDetail(post.getDetail());
        dto.setCategory(post.getCategory());
        dto.setPrice(post.getPrice());
        dto.setHasPromo(post.isHasPromo());
        dto.setDiscount(post.getDiscount());
        return dto;
    }
}
