package com.example.socialmeli.mappers;


import com.example.socialmeli.models.Post;
import com.example.socialmeli.models.dtos.PostDTO;

public class PostMapper {

    public static PostDTO PostToDTO(Post post) {
        return new PostDTO(post);
    }

    public static Post DTOToPost(PostDTO postDTO) {
        return new Post(postDTO);
    }
}
