package com.springChallenge.api.service.mapper.product;

import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.repository.entity.Post;
import java.util.ArrayList;

public class PostsListMapper {
    public static PostsListDTO toDTO(Integer userId, ArrayList<Post> posts){
        return new PostsListDTO(
                userId,
                PostMapper.toDTOList(posts)
        );
    }
}
