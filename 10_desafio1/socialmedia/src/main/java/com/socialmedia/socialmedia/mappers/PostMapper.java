package com.socialmedia.socialmedia.mappers;

import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.services.dtos.PostDTO;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {
    public static Post postDtoToPost(PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getPostId());
        post.setUserId(postDTO.getUserId());
        post.setPostId(postDTO.getPostId());
        post.setProductId(postDTO.getDetail().getProductId());
        post.setDate(postDTO.getDate());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());

        return post;
    }

    public static List<PostDTO> postsToPostDTOs(List<Post> posts) {
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post: posts) {
            postDTOS.add(postToPostDTO(post));
        }
        return postDTOS;
    }

    public static PostDTO postToPostDTO(Post post) {
        PostDTO result = new PostDTO();

        result.setPostId(post.getId());
        result.setDate(post.getDate());
        result.setCategory(post.getCategory());
        result.setPrice(post.getPrice());
        result.setUserId(post.getUserId());

        return result;
    }
}
