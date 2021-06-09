package com.example.SocialMeli.Services.Mapper;


import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.PostDTO;
import com.example.SocialMeli.Services.DTOs.ProductDTO;
import com.example.SocialMeli.Services.DTOs.UserDTO;

import java.util.List;

public class PostMapper {

    public static PostDTO toDTO(Post post){

        return new PostDTO(post.getUserId(), post.getId(), post.getDate(),null, post.getCategory(), post.getPrice());
    }
    public static PostDTO toDTO(Post post, Product detail){

        return new PostDTO(post.getUserId(), post.getId(), post.getDate(),ProductMapper.toDTO(detail), post.getCategory(), post.getPrice());
    }
    public static Post toPost(PostDTO postDTO){
        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice());
    }


}
