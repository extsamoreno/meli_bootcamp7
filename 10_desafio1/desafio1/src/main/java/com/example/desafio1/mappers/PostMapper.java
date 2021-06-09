package com.example.desafio1.mappers;


import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.example.desafio1.models.Post;

public class PostMapper {

    public static PostDTO PostToDTO(Post post) {
        return new PostDTO(post);
    }

    public static Post PostDTOToPost(PostDTO postDTO) {
        return new Post(postDTO);
    }

    public static PostPromoDTO PostPromoToDTO(Post post) {
        return new PostPromoDTO(post);
    }

    public static Post PostPromoDTOToPost(PostPromoDTO postPromoDTO) {
        return new Post(postPromoDTO);
    }
}
