package com.example.DesafioSpring.services.mapper;

import com.example.DesafioSpring.dto.PostDTO;
import com.example.DesafioSpring.dto.ProductDTO;
import com.example.DesafioSpring.models.Post;
import com.example.DesafioSpring.models.Product;

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
