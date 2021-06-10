package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.post.PostDTO;
import com.meli.socialmeli.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
    public static Post toPost(PostDTO newPost) {
        return new Post(
                newPost.getUserId(),
                newPost.getPostId(),
                newPost.getDate(),
                ProductMapper.toProduct(newPost.getDetail()),
                newPost.getCategory(),
                newPost.getPrice(),
                newPost.isHasPromo(),
                newPost.getDiscount());
    }

    public static PostDTO toPostDTO(Post post) {
        return new PostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getDate(),
                ProductMapper.toProductDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    public static List<PostDTO> toPostsDTO(List<Post> posts) {
        return posts.stream().map(PostMapper::toPostDTO).collect(Collectors.toList());
    }
}
