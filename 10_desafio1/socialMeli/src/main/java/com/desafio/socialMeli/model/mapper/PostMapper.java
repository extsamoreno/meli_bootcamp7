package com.desafio.socialMeli.model.mapper;

import com.desafio.socialMeli.model.dao.models.Post;
import com.desafio.socialMeli.model.dto.PostDTO;
import com.desafio.socialMeli.model.dto.UserFollowedPostsDTO;

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

