package com.example.SocialMeli.Services.Mapper;


import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.PostDTO;
import com.example.SocialMeli.Services.DTOs.UserDTO;

public class PostMapper {

    public static PostDTO toDTO(Post post){
        return new PostDTO();
    }

    public static Post toPost(PostDTO postDTO){
        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice());
    }
}
