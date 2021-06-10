package com.example.desafio1.service.mapper;

import com.example.desafio1.model.Post;
import com.example.desafio1.service.dto.post.ResponsePostDTO;
import com.example.desafio1.service.dto.post.ResponsePromoPostDTO;

public class PostMapper {

    // Post to ResponsePostDTO (without promo)
    public static ResponsePostDTO postToDto(Post post){
        return new ResponsePostDTO(post.getPostId(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }

    // Post to ResponsePromoPostDTO (post with promo)
    public static ResponsePromoPostDTO postToPromoDTO(Post post){
        return new ResponsePromoPostDTO(post.getPostId(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice(), post.isHasPromo(), post.getDiscount());
    }
}
