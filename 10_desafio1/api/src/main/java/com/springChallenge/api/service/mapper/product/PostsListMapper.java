package com.springChallenge.api.service.mapper.product;

import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.repository.entity.User;

public class PostsListMapper {
    public static PostsListDTO toDTO(User user){
        return new PostsListDTO(
                user.getUserId(),
                PostMapper.toDTOList(user.getPosts())
        );
    }
}
