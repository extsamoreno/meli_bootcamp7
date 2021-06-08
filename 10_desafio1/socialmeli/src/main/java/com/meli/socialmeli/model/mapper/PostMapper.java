package com.meli.socialmeli.model.mapper;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.PostDTO;

import java.text.SimpleDateFormat;

public class PostMapper {
    public static PostDTO changeToPostDTO(Post post) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        PostDTO postDTO = new PostDTO();
        postDTO.setIdPost(post.getIdPost());
        postDTO.setDate(formatter.format(post.getDate()));
        postDTO.setDetail(post.getDetail());
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());
        return postDTO;
    }

}
