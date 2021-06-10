package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.example.desafio1.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostMapper {
    public static Post toModel(PostDTO pubDTO) {
        Post post = new Post();
        post.setIdPost(pubDTO.getIdPost());
        post.setCategory(pubDTO.getCategory());
        post.setDate(pubDTO.getDate());
        post.setDetail(ProductMapper.toModel(pubDTO.getDetail()));
        post.setUserId(pubDTO.getUserId());
        post.setPrice(pubDTO.getPrice());
        if(pubDTO instanceof PostPromoDTO){
            post.setHasPromo(((PostPromoDTO) pubDTO).isHasPromo());
            post.setDiscount(((PostPromoDTO) pubDTO).getDiscount());
        }
        return post;
    }

    public static List<PostDTO> toDTOList(List<Post> pubList){
        List<PostDTO> pubDTOList = new ArrayList<>();
        PostDTO pubDTO;
        for (Post post : pubList) {
            pubDTO = post.isHasPromo()? new PostPromoDTO() : new PostDTO();
            pubDTO.setIdPost(post.getIdPost());
            pubDTO.setDate(post.getDate());
            pubDTO.setCategory(post.getCategory());
            pubDTO.setDetail(ProductMapper.toDTO(post.getDetail()));
            pubDTO.setPrice(post.getPrice());
            pubDTO.setUserId(post.getUserId());
            if(pubDTO instanceof PostPromoDTO){
                ((PostPromoDTO) pubDTO).setDiscount(post.getDiscount());
                ((PostPromoDTO) pubDTO).setHasPromo(post.isHasPromo());
            }
            pubDTOList.add(pubDTO);
        }
        return pubDTOList;
    }
}
