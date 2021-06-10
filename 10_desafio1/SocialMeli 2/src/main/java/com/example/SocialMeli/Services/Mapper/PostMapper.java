package com.example.SocialMeli.Services.Mapper;


import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;

import java.util.List;

public class PostMapper {


    public static PostDTO toDTO(Post post, Product detail){

        return new PostDTO(post.getUserId(), post.getId(), post.getDate(),ProductMapper.toDTO(detail), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
    }
    public static Post toPost(NonPromoPostDTO postDTO){

        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice(),false, 0.0);
    }
    public static Post toPost(PromoPostDTO postDTO){
        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice(),postDTO.getHasPromo(), postDTO.getDiscount());
    }
}
