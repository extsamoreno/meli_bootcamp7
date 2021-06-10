package com.desafio.socialMeli.service.mapper;

import com.desafio.socialMeli.repository.entities.Post;
import com.desafio.socialMeli.service.dto.PostDTO;
import com.desafio.socialMeli.service.dto.UserFollowedPostsDTO;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {
    public static PostDTO toPostDTO(Post post) {
        return new PostDTO(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.gethasPromo(),
                post.getDiscount()
        );
    }

    public static UserFollowedPostsDTO toUserFollowedPostsDTO(List<PostDTO> allPostsDTOFollowed) {
     UserFollowedPostsDTO userFollowedPostsDTO = new UserFollowedPostsDTO();
     for(PostDTO p : allPostsDTOFollowed){

     }
     userFollowedPostsDTO.setPosts(allPostsDTOFollowed);
     return userFollowedPostsDTO;
    }
}

