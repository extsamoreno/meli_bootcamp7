package com.example.desafiospring.socialmeli.service.mapper;

import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostMapper {

    public static Post getPost(PostDTO postDTO){
        return new Post(
                postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                postDTO.getDetails(),
                postDTO.getCategory(),
                postDTO.getPrice()
        );
    }
}
