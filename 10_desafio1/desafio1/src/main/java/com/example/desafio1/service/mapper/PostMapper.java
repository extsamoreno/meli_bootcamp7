package com.example.desafio1.service.mapper;

import com.example.desafio1.model.Post;
import com.example.desafio1.service.dto.post.ResponsePostDTO;

public class PostMapper {

    // Post to ResponsePostDTO
    public static ResponsePostDTO postToDto(Post post){
        return new ResponsePostDTO(post.getIdPost(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }
}
