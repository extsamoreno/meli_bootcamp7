package com.desafiospring.socialMeli.service.mapper;

import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.model.Post;

public class PostMapper {

    public static Post toPost(PostDTO postDTO) {
        return new Post(postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                postDTO.getDetail(),
                postDTO.getCategory(),
                postDTO.getPrice());
    }


}
