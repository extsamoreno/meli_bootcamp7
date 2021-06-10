package com.example.DesafioSpring.services.mapper;

import com.example.DesafioSpring.dto.NoPromoDTO;
import com.example.DesafioSpring.dto.PostDTO;
import com.example.DesafioSpring.dto.PromoPostDTO;
import com.example.DesafioSpring.models.Post;
import com.example.DesafioSpring.models.Product;

public class PostMapper {
    public static PostDTO toDTO(Post post, Product detail){
        return new PostDTO(post.getUserId(), post.getId(), post.getDate(),ProductMapper.toDTO(detail), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
    }
    public static Post toPost(NoPromoDTO postDTO){
        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice(),false, 0.0);
    }
    public static Post toPost(PromoPostDTO postDTO){
        return new Post(postDTO.getPostId(), postDTO.getUserId(), postDTO.getDate(), postDTO.getDetail().getId(), postDTO.getCategory(), postDTO.getPrice(),postDTO.getHasPromo(), postDTO.getDiscount());
    }
}
