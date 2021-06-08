package com.example.desafio1.mappers;


import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.models.Post;

public class PostMapper {

    public static PostDTO PostToDTO(Post post) {
        return new PostDTO(post);
    }

    public static Post DTOToPost(PostDTO postDTO) {
        return new Post(postDTO);
    }
}
