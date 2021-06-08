package com.spring.desafioSpring.Services.Mappers;

import com.spring.desafioSpring.DTOs.PostDTO;
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
        return post;
    }
}
