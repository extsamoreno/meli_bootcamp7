package com.springChallenge.api.service.mapper.product;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.repository.entity.Post;

import java.util.ArrayList;

public class PostMapper {
    public static PostDTO[] toDTOList(ArrayList<Post> posts){
        return posts
                .stream()
                .map(PostMapper::toDTO)
                .toArray(PostDTO[]::new);
    }

    public static PostDTO toDTO(Post post){
        return new PostDTO(
                post.getUserId(),
                post.getIdPost(),
                post.getDate(),
                ProductMapper.toDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice()
        );
    }

    public static Post toEntity(PostDTO dto){
        return new Post(
                dto.getUserId(),
                dto.getIdPost(),
                dto.getDate(),
                ProductMapper.toEntity(dto.getDetail()),
                dto.getCategory(),
                dto.getPrice()
        );
    }
}
