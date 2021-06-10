package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.post.NewPostDTO;
import com.meli.socialmeli.dto.post.NewPromoPostDTO;
import com.meli.socialmeli.dto.post.PostDTO;
import com.meli.socialmeli.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {
    public static Post toPost(NewPostDTO newPost) {
        Post post = new Post();
        post.setUserId(newPost.getUserId());
        post.setPostId(newPost.getPostId());
        post.setDate(newPost.getDate());
        post.setDetail(ProductMapper.toProduct(newPost.getDetail()));
        post.setCategory(newPost.getCategory());
        post.setPrice(newPost.getPrice());
        return post;
    }

    public static Post toPromoPost(NewPromoPostDTO newPromoPost) {
        Post post = new Post();
        post.setUserId(newPromoPost.getUserId());
        post.setPostId(newPromoPost.getPostId());
        post.setDate(newPromoPost.getDate());
        post.setDetail(ProductMapper.toProduct(newPromoPost.getDetail()));
        post.setCategory(newPromoPost.getCategory());
        post.setPrice(newPromoPost.getPrice());
        post.setHasPromo(newPromoPost.isHasPromo());
        post.setDiscount(newPromoPost.getDiscount());
        return post;
    }

    public static PostDTO toPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(post.getUserId());
        postDTO.setPostId(post.getPostId());
        postDTO.setDate(post.getDate());
        postDTO.setDetail(ProductMapper.toProductDTO(post.getDetail()));
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());
        postDTO.setHasPromo(post.isHasPromo());
        postDTO.setDiscount(post.getDiscount());
        return postDTO;
    }

    public static List<PostDTO> toPostsDTO(List<Post> posts) {
        return posts.stream().map(PostMapper::toPostDTO).collect(Collectors.toList());
    }
}
