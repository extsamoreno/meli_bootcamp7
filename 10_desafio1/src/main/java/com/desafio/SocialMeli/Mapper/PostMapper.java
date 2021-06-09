package com.desafio.SocialMeli.Mapper;

import com.desafio.SocialMeli.Classes.Post;
import com.desafio.SocialMeli.DTO.Post.PostDTO;
import com.desafio.SocialMeli.DTO.Post.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.Post.PromoPostDTO;
import com.desafio.SocialMeli.DTO.Post.PromoPostWithUserDTO;

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

    public static Post PostWithUserDTOtoPost(PostWithUserDTO postDTO){
        return new Post(postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                ProductMapper.toProduct(postDTO.getDetail()),
                postDTO.getCategory(),
                postDTO.getPrice(),
                false,
                0.0);
    }

    public static Post PromoPostDTOtoPost(PromoPostWithUserDTO promoPostWithUserDTO){
        return new Post(promoPostWithUserDTO.getUserId(),
                promoPostWithUserDTO.getId_post(),
                promoPostWithUserDTO.getDate(),
                ProductMapper.toProduct(promoPostWithUserDTO.getDetail()),
                promoPostWithUserDTO.getCategory(),
                promoPostWithUserDTO.getPrice(),
                promoPostWithUserDTO.isHasPromo(),
                promoPostWithUserDTO.getDiscount());
    }

    public static PromoPostDTO toPromoPostDTO(Post post){
        return new PromoPostDTO(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                ProductMapper.toDTO(post.getDetail()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
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
