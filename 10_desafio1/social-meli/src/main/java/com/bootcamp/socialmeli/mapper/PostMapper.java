package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.ListFollowedPostDTO;
import com.bootcamp.socialmeli.DTO.PostFollowedDTO;
import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import com.bootcamp.socialmeli.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostMapper {

    @Autowired
    ProductMapper productMapper;

    public Post toPost(PostRequestDTO postRequestDTO) {
        return new Post(
                postRequestDTO.getUserId(),
                postRequestDTO.getPostId(),
                postRequestDTO.getDate(),
                productMapper.toProdcut(postRequestDTO.getDetail()),
                postRequestDTO.getCategory(),
                postRequestDTO.getPrice()
        );
    }

    public ListFollowedPostDTO toListFollowedPostDTO(List<Post> postFollowed, Integer userId) {
        ListFollowedPostDTO listFollowedPost = new ListFollowedPostDTO();
        listFollowedPost.setUserId(userId);


        return null;
    }

    PostFollowedDTO toPostFollowedDTO(Post post) {
        return null;
    }
}
