package com.desafio.SocialMeli.Mapper;

import com.desafio.SocialMeli.Classes.Post;
import com.desafio.SocialMeli.DTO.FollowedPostListDTO;
import com.desafio.SocialMeli.DTO.PostDTO;
import com.desafio.SocialMeli.DTO.PostWithUserDTO;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {
    public static PostWithUserDTO toDTO(Post post){
        return new PostWithUserDTO(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                ProductMapper.toDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice());
    }

    public static Post toPost(PostWithUserDTO postDTO){
        return new Post(postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                ProductMapper.toProduct(postDTO.getDetail()),
                postDTO.getCategory(),
                postDTO.getPrice());
    }

    public static List<PostDTO> toPostDTO(List<Post> postList){
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post p : postList) {
            PostDTO postDTO = new PostDTO();
            postDTO.setId_post(p.getId_post());
            postDTO.setCategory(p.getCategory());
            postDTO.setDate(p.getDate());
            postDTO.setDetail(ProductMapper.toDTO(p.getDetail()));
            postDTO.setPrice(p.getPrice());
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

}
